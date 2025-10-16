package kr.co.khBootAdmin.service.impl;

import kr.co.khBootAdmin.mapper.EventMapper;
import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.EventDetailResponse;
import kr.co.khBootAdmin.model.payload.request.EventRequest;
import kr.co.khBootAdmin.model.vo.*;
import kr.co.khBootAdmin.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;

@Service
@Slf4j
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventMapper eventMapper;

    /**
     * 게시물 목록 + 카운트
     * @param searchHelper
     * @return
     */
    @Override
    public HashMap<String, Object> selectEvent(SearchHelper searchHelper) {
        HashMap<String, Object> resultMap = new HashMap<>();

        float totalElements = (float) eventMapper.countEvent(searchHelper);

        resultMap.put("list", eventMapper.selectEventWithPrizes(searchHelper));
        resultMap.put("totalElements", totalElements);
        resultMap.put("size", searchHelper.getSize());
        resultMap.put("currentPage", Math.ceil((double) searchHelper.getPage() / searchHelper.getSize()) + 1);
        resultMap.put("totalPages", Math.ceil(totalElements / searchHelper.getSize()));
        resultMap.put("last", searchHelper.getPage() >= searchHelper.getSize());

        return resultMap;
    }

    @Override
    public EventDetailResponse selectEventDetail(Long eventId) {
        // Mapper에서 VO로 받아오기
        EventDetailResponse response = eventMapper.selectEventDetail(eventId);
        // 결과 없을 경우 예외 처리 (선택사항)
        if (response == null) {
            throw new IllegalArgumentException("해당 이벤트가 존재하지 않습니다.");
        }

        // VO → DTO 수동 매핑 (필요한 필드만 전달)
        return response;
    }

    @Transactional
    @Override
    public void eventSave(EventRequest eventRequest, CustomUserDetails user) {
        log.info("saveBoard : {}", eventRequest.toString());
        log.info(user.toString());
        
        log.info("Received eventCode: {}", eventRequest.getEventCode());
        log.info("Received eventTitle: {}", eventRequest.getEventTitle());
        log.info("Received eventStartDate: {}", eventRequest.getEventStartDate());
        log.info("Received eventEndDate: {}", eventRequest.getEventEndDate());

        // 이벤트 ID가 0인 경우 -> 새로 등록하는 경우
        log.info("if문 들어가기 전 테스트");
        if (eventRequest.getEventId() == 0) {
            log.info("if문 들어온 후 테스트");
            // EventVO 객체를 빌더 패턴을 사용하여 생성
            EventVO event = EventVO.builder()
                    .eventCode(eventRequest.getEventCode())  // eventCode
                    .eventTitle(eventRequest.getEventTitle()) // eventTitle
                    .eventContent(eventRequest.getEventContent()) // eventContent
                    .eventCreateId(user.getUsername())  // eventCreateId
                    .eventUpdateId(user.getUsername())  // eventUpdateId
                    .eventStartDate(eventRequest.getEventStartDate()) // eventStartDate
                    .eventEndDate(eventRequest.getEventEndDate())     // eventEndDate
                    .build();


            log.info("등록할 이벤트 객체: {}", event.toString());

            // DB에 insert하고, 자동 생성된 eventId를 받아오기
            eventMapper.eventEntity(event);  // eventMapper의 insert 쿼리가 수행됨
            // DB에서 자동 생성된 eventId가 event 객체에 설정되어 있음

            log.info("새로 생성된 eventId: {}", event.getEventId()); // 자동 생성된 eventId를 로그로 확인
            EventPrizeVO eventPrize = EventPrizeVO.builder()
                    .eventId(event.getEventId())
                    .prizeName(eventRequest.getPrizeName())
                    .quantity(eventRequest.getQuantity())
                    .build();
            eventMapper.eventPrizeEntity(eventPrize);
            log.info("등록할 경품 객체: {}", eventPrize.toString());

        } else {
            log.info("기존에 등록되어 있는 이벤트 정보 수정");
            log.info("받아온 이벤트 정보 리스트 : " + eventRequest.toString());
            // 수정 처리: eventId가 0이 아닌 경우 (기존 데이터 수정)
            EventVO event = EventVO.builder()
                    .eventId(eventRequest.getEventId())  // 기존 eventId (수정 대상)
                    .eventCode(eventRequest.getEventCode())
                    .eventTitle(eventRequest.getEventTitle())
                    .eventContent(eventRequest.getEventContent())
                    .eventCreateId(user.getUsername())
                    .eventUpdateId(user.getUsername())
                    .eventStartDate(eventRequest.getEventStartDate())
                    .eventEndDate(eventRequest.getEventEndDate())
                    .build();

            EventPrizeVO eventPrize = EventPrizeVO.builder()
                    .eventId(eventRequest.getEventId())
                    .prizeName(eventRequest.getPrizeName())
                    .quantity(eventRequest.getQuantity())
                    .build();

            log.info("수정할 이벤트 객체: {}", event.toString());

            // 수정된 내용을 DB에 업데이트
            eventMapper.eventUpdate(event);  // eventMapper의 update 쿼리가 수행됨
            eventMapper.eventPrizeUpdate(eventPrize);  // eventMapper의 update 쿼리가 수행됨

        }
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventMapper.deleteById(eventId);
    }


}
