package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.payload.request.BoardRequest;
import kr.co.khBootAdmin.model.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

    List<BoardVO> selectBoard(BoardRequest searchHelper);

    int countBoard(BoardRequest searchHelper);

    void boardSave(BoardVO board);

    Optional<BoardVO> boardInfo(Long id);

    void updateBoard(BoardVO board);

    void deleteBoard(Long id);

}
