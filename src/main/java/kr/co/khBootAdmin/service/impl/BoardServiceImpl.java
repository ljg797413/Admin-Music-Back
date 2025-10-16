package kr.co.khBootAdmin.service.impl;

import kr.co.khBootAdmin.exception.BadRequestException;
import kr.co.khBootAdmin.exception.NotFoundException;
import kr.co.khBootAdmin.mapper.BoardMapper;
import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.payload.request.BoardDeleteRequest;
import kr.co.khBootAdmin.model.payload.request.BoardRequest;
import kr.co.khBootAdmin.model.payload.request.FileDeleteRequest;
import kr.co.khBootAdmin.model.vo.BoardVO;
import kr.co.khBootAdmin.model.vo.FileMap;
import kr.co.khBootAdmin.model.vo.UploadFile;
import kr.co.khBootAdmin.service.BoardService;
import kr.co.khBootAdmin.service.FileMapService;
import kr.co.khBootAdmin.service.UploadFileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;
    private final UploadFileService uploadFileService;
    private final FileMapService fileMapService;

    @Override
    public HashMap<String, Object> selectBoard(BoardRequest searchHelper) {
        HashMap<String, Object> resultMap = new HashMap<>();

        float totalElements = (float) boardMapper.countBoard(searchHelper);

        resultMap.put("list", boardMapper.selectBoard(searchHelper));
        resultMap.put("totalElements", totalElements);
        resultMap.put("size", searchHelper.getSize());
        resultMap.put("currentPage", Math.ceil((double) searchHelper.getPage() / searchHelper.getSize()) + 1);
        resultMap.put("totalPages", Math.ceil(totalElements / searchHelper.getSize()));
        resultMap.put("last", searchHelper.getPage() >= searchHelper.getSize());
        return resultMap;
    }

    @Transactional
    @Override
    public void saveBoard(CustomUserDetails currentUser, BoardRequest boardRequest) {
        log.info("saveBoard : {}", boardRequest.toString());
        if (boardRequest.getId() == null) {
            BoardVO board = BoardVO.builder()
                    .noticeCodeId(boardRequest.getNoticeCodeId())
                    .noticeTitle(boardRequest.getNoticeTitle())
                    .noticeContent(boardRequest.getNoticeContent())
                    .noticeCreateId(currentUser.getUsername())
                    .noticeUpdateId(currentUser.getUsername())
                    .build();

            log.info(board.toString());

            boardMapper.boardSave(board);

            List<UploadFile> fileList = boardRequest.getFileList();
            for (UploadFile file : fileList) {
                FileMap fileMap = FileMap.builder()
                        .boardId(board.getNoticeId())
                        .fileId(file.getId())
                        .build();
                fileMapService.insertFileMap(fileMap);
            }
        } else {
            BoardVO board = BoardVO.builder()
                    .noticeCodeId(boardRequest.getNoticeCodeId())
                    .noticeTitle(boardRequest.getNoticeTitle())
                    .noticeContent(boardRequest.getNoticeContent())
                    .noticeCreateId(currentUser.getUsername())
                    .noticeUpdateId(currentUser.getUsername())
                    .build();

            log.info(board.toString());

            boardMapper.updateBoard(board);

            List<UploadFile> fileList = boardRequest.getFileList();
            for (UploadFile file : fileList) {
                FileMap fileMap = FileMap.builder()
                        .boardId(board.getNoticeId())
                        .fileId(file.getId())
                        .build();
                Boolean checkFileMap = fileMapService.checkFileMap(fileMap);
                if (!checkFileMap) {
                    fileMapService.insertFileMap(fileMap);
                }
            }
        }
    }

    @Override
    public HashMap<String, Object> boardInfo(Long id) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Optional<BoardVO> result = boardMapper.boardInfo(id);
        List<UploadFile> fileList = new ArrayList<>();
        if (result.isPresent()) {
//            fileList = uploadFileService.selectFileByBoardId(id);
        } else {
            throw new NotFoundException("해당 게시물을 찾을 수 없습니다.");
        }
        resultMap.put("info", result.get());
        resultMap.put("uploadFiles", fileList);

        return resultMap;
    }

    @Transactional
    @Override
    public void deleteBoard(BoardDeleteRequest request) {
        log.info(request.toString());

        if (!request.getId().isEmpty()) {
            for (Long id : request.getId()) {
                Optional<BoardVO> info = boardMapper.boardInfo(id);
                log.info("boardInfo");
                List<UploadFile> fileList = new ArrayList<>(); //uploadFileService.selectFileByBoardId(id);
                log.info("selectFileByBoardId");
                if (info.isPresent()) {
                    for (UploadFile item : fileList) {
                        FileDeleteRequest fileDeleteRequest = new FileDeleteRequest();
                        fileDeleteRequest.setId(item.getId());
                        fileDeleteRequest.setFileTarget(item.getFileTarget());
                        uploadFileService.deleteAsResource(fileDeleteRequest);
                        log.info("deleteAsResource");
                    }
                    boardMapper.deleteBoard(id);
                    log.info("deleteBoard");
                } else {
                    throw new BadRequestException("해당 게시물을 찾을 수 없습니다.");
                }
            }
        }
    }
}
