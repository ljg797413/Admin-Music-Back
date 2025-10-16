package kr.co.khBootAdmin.controller.admin;

import kr.co.khBootAdmin.model.vo.ArtistVO;
import kr.co.khBootAdmin.service.ArtistService;
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
@RequestMapping("/api/admin/artist")
public class ArtistController {
    private final ArtistService artistService;
    @GetMapping("/count")
    public ResponseEntity<?> viewCount(@RequestParam String artistName, @RequestParam Long rowsPerPage, @RequestParam Long page) {
        ArtistVO artistVO = new ArtistVO();
        artistVO.setArtistName(artistName);
        artistVO.setOffset(page*rowsPerPage);
        artistVO.setFetch(rowsPerPage);
        log.info(artistVO.toString());
        return ResponseEntity.ok(artistService.followCount(artistVO));
    }
}
