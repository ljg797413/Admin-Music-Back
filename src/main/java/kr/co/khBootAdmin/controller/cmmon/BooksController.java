package kr.co.khBootAdmin.controller.cmmon;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import kr.co.khBootAdmin.model.vo.BooksVO;
import kr.co.khBootAdmin.service.impl.BooksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BooksService booksService;

    @ApiOperation(value = "도서 목록 호출")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "도서 제목 검색", dataTypeClass = String.class, required = false)
    })

    @GetMapping("/list")
    public ResponseEntity<?> list(@RequestParam String title) {
        BooksVO booksVO = new BooksVO();
        return ResponseEntity.ok(booksService.selectList(booksVO));
    }

    @ApiOperation(value = "데이터 저장")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "booksVO", value = "책 정보", dataTypeClass = BooksVO.class, required = false)
    })
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BooksVO booksVO) {
        booksService.insert(booksVO);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "데이터 수정")
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody BooksVO booksVO) {
        booksService.update(booksVO);
        return ResponseEntity.ok().build();
    }

//    @CurrentUser CustomUserDetails currentUser
    @ApiOperation(value = "데이터 삭제")
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<?> delete(@PathVariable Long bookId) {
        booksService.delete(bookId);
        return ResponseEntity.ok().build();
    }

}
