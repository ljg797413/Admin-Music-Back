package kr.co.khBootAdmin.controller.admin;

import kr.co.khBootAdmin.model.vo.TrackVO;
import kr.co.khBootAdmin.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/track")
public class TrackController {
    private final UserService userService;

    @GetMapping("/count")
    public ResponseEntity<?> viewCount(@RequestParam String trackName, @RequestParam Long rowsPerPage, @RequestParam Long page) {
    TrackVO trackVO = new TrackVO();
    trackVO.setTrackName(trackName);
    trackVO.setOffset(page*rowsPerPage);
    trackVO.setFetch(rowsPerPage);
        log.info(trackVO.toString());
        log.info(userService.selectCount(trackVO).toString());
        return ResponseEntity.ok(userService.selectCount(trackVO));
    }
}
