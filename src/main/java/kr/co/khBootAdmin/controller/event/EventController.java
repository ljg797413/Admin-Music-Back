package kr.co.khBootAdmin.controller.event;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import kr.co.khBootAdmin.annotation.CurrentUser;
import kr.co.khBootAdmin.model.CustomUserDetails;
import kr.co.khBootAdmin.model.payload.request.EventRequest;
import kr.co.khBootAdmin.model.vo.SearchHelper;
import kr.co.khBootAdmin.service.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/event")
@Slf4j
@AllArgsConstructor
public class EventController {

    private final EventService eventService;
    /**
     * 현재 사용자의 프로필 리턴
     * @param request
     * @return
     */
    // 이벤트 리스트 페이지
    @GetMapping("/eventList")
    @ApiOperation(value = "이벤트 목록 조회")
    @ApiImplicitParam(name = "request", value = "검색 객체", dataType = "SearchHelper", dataTypeClass = SearchHelper.class, required = true)
    public ResponseEntity<?> EventList(@ModelAttribute SearchHelper request) {
        // 예: 이벤트 서비스에서 목록 조회

        log.info("테스트중");
        return ResponseEntity.ok(eventService.selectEvent(request));  // JSON으로 반환
    }

    @GetMapping("/eventDetail/{eventId}")
    @ApiOperation(value = "이벤트 세부정보 조회")
    public ResponseEntity<?> getEventDetail(@ApiParam(value = "이벤트 ID", required = true)@PathVariable Long eventId) {
        log.info("이벤트 ID: {}", eventId);

        return ResponseEntity.ok(eventService.selectEventDetail(eventId));  // 서비스에 eventId 전달
    }

//    @PostMapping("/save")
//    public ResponseEntity<?> EventSave(EventVO eventVO) {
//        log.info("이벤트 ID: {}", eventVO);
//
//           eventService.eventSave(request, user);
//        return ResponseEntity.ok().build();
//    }

    @ApiOperation(value = "이벤트 저장")
    @PostMapping("/save")
    public ResponseEntity<?> EventSave(@RequestBody EventRequest request, @CurrentUser CustomUserDetails user) {
        log.info("-->" + request.toString());
        log.info(user.toString());

        // 자동으로 LocalDateTime으로 변환되었으므로 추가 변환 없이 바로 사용
        log.info("시작일 : " + request.getEventStartDate());
        log.info("종료일 : " + request.getEventEndDate());

        // eventSave 호출
        eventService.eventSave(request, user);

        return ResponseEntity.ok("저장되었습니다.");
    }

    @ApiOperation(value = "이벤트 수정")
    @PutMapping("/update/{eventId}")
    public ResponseEntity<?> eventUpdate(
            @PathVariable Long eventId,
            @RequestBody EventRequest request,
            @CurrentUser CustomUserDetails user) {

        log.info("수정 요청 들어옴: {}", request);
        request.setEventId(eventId); // path로 받은 ID를 직접 설정
        log.info("테스트 : " + eventId);
        eventService.eventSave(request, user);
        return ResponseEntity.ok("수정되었습니다.");
    }




    @ApiOperation(value = "이벤트 삭제")
    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<?> deleteEvent(@PathVariable Long eventId) {

        log.info("이벤트값 : " + eventId);
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("이벤트가 삭제되었습니다.");
    }


}
