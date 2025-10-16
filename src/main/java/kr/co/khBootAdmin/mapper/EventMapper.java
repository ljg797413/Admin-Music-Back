package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.EventDetailResponse;
import kr.co.khBootAdmin.model.vo.BoardVO;
import kr.co.khBootAdmin.model.vo.EventPrizeVO;
import kr.co.khBootAdmin.model.vo.EventVO;
import kr.co.khBootAdmin.model.vo.SearchHelper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EventMapper {

    List<BoardVO> selectEventWithPrizes(SearchHelper searchHelper);

    Long countEvent(SearchHelper searchHelper);

    void boardSave(BoardVO board);

    Optional<BoardVO> boardInfo(Long id);

    void updateBoard(BoardVO board);

    void deleteBoard(Long id);

    EventDetailResponse selectEventDetail(Long eventId);

    // 이벤트 등록
    void eventEntity(EventVO eventVO);
    void eventPrizeEntity(EventPrizeVO eventPrizeVO);

    // 이벤트 수정
    void eventUpdate(EventVO eventVO);
    void eventPrizeUpdate(EventPrizeVO eventPrizeVO);

    // 이벤트 삭제
    void deleteById(Long eventId);
}



