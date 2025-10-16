package kr.co.khBootAdmin.controller.admin;

import io.swagger.annotations.ApiOperation;
import kr.co.khBootAdmin.annotation.CurrentUser;
import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.payload.request.BoardDeleteRequest;
import kr.co.khBootAdmin.model.payload.request.BoardRequest;
import kr.co.khBootAdmin.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "공지사항 목록 조회")
    @GetMapping("/list")
    public ResponseEntity<?> list(BoardRequest request) {
        return ResponseEntity.ok(boardService.selectBoard(request));
    }

    @ApiOperation(value = "공지사항 저장")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BoardRequest request, @CurrentUser CustomUserDetails user) {
        log.info(user.toString());
        // 12이거 쓰면 사용자 아이디 획득 user.getUsername()
        // request.setNoticeCreateId(user.getUsername());
        // 임시 사용자 정보 하드코딩
        // CustomUserDetails currentUser = new CustomUserDetails("admin", "ROLE_ADMIN");
        boardService.saveBoard(user, request);
        return ResponseEntity.ok("저장되었습니다.");
    }


    @ApiOperation(value = "공지사항 상세 조회")
    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        log.info("공지사항 정보 : " + id);
        HashMap<String, Object> result = boardService.boardInfo(id);
        return ResponseEntity.ok(result);
    }

    @ApiOperation(value = "공지사항 삭제")
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody BoardDeleteRequest request) {
        log.info("공지사항 삭제쪽");
        boardService.deleteBoard(request);
        return ResponseEntity.ok("삭제되었습니다.");
    }
}
