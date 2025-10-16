package kr.co.khBootAdmin.controller.admin;

import io.swagger.annotations.ApiOperation;
import kr.co.khBootAdmin.model.vo.ArtistVO;
import kr.co.khBootAdmin.model.vo.TrackVO;
import kr.co.khBootAdmin.service.ArtistService;
import kr.co.khBootAdmin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stats")
public class DashBoardController {

    private final ArtistService artistService;
    private final UserService userService;

    /**
     * 🎵 일일 재생 수 TOP10
     */
    @ApiOperation(value = "일일 재생수")
    @GetMapping("/daily-play")
    public ResponseEntity<?> dailyPlay() {
        LocalDate today = LocalDate.now();

        TrackVO trackVO = new TrackVO();
        trackVO.setLocalDate(today);
        trackVO.setLocalDateStr(String.valueOf(today));
        trackVO.setOffset(0L);
        trackVO.setFetch(5L);

        List<TrackVO> result = userService.selectCount(trackVO);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    /**
     * 👤 일일 팔로우 수 TOP10
     */
    @ApiOperation(value = "일일 팔로우수")
    @GetMapping("/daily-follow")
    public ResponseEntity<?> dailyFollow() {
        LocalDate today = LocalDate.now();
        log.info(today.toString());

        ArtistVO artistVO = new ArtistVO();
        artistVO.setLocalDate(today);
        artistVO.setLocalDateStr(String.valueOf(today));
        artistVO.setOffset(0L);
        artistVO.setFetch(5L);

        List<ArtistVO> result = artistService.followCount(artistVO);
        return ResponseEntity.ok(result);
    }

    /**
     * 🎵 주간 재생 수 TOP10
     */
    @ApiOperation(value = "주간 재생수")
    @GetMapping("/weekly-play")
    public ResponseEntity<?> weeklyPlay() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);

        TrackVO trackVO = new TrackVO();
        trackVO.setStartDate(startDate);
        trackVO.setEndDate(endDate);
        trackVO.setOffset(0L);
        trackVO.setFetch(5L);
//        trackVO.setLocalDate(endDate);
        trackVO.setStartDateStr(String.valueOf(startDate));
        trackVO.setEndDateStr(String.valueOf(endDate));

        List<TrackVO> result = userService.selectCount(trackVO);
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

    /**
     * 👤 주간 팔로우 수 TOP10
     */
    @ApiOperation(value = "주간 팔로우수")
    @GetMapping("/weekly-follow")
    public ResponseEntity<?> weeklyFollow() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(6);


        log.info(endDate.toString());
        log.info(startDate.toString());

        ArtistVO artistVO = new ArtistVO();
        artistVO.setStartDate(startDate);
        artistVO.setEndDate(endDate);


        artistVO.setOffset(0L);
        artistVO.setFetch(5L);
//        artistVO.setLocalDate(endDate);
        artistVO.setStartDateStr(String.valueOf(startDate));
        artistVO.setEndDateStr(String.valueOf(endDate));
//        artistVO.setLocalDateStr(String.valueOf(endDate));

        List<ArtistVO> result = artistService.followCount(artistVO);
        return ResponseEntity.ok(result);
    }
}
