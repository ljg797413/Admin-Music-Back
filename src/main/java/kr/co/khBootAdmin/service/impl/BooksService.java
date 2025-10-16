package kr.co.khBootAdmin.service.impl;

import kr.co.khBootAdmin.mapper.BooksMapper;
import kr.co.khBootAdmin.model.vo.BooksVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BooksService {

    private final BooksMapper booksMapper;

    public List<BooksVO> selectList(BooksVO booksVO) {
        return booksMapper.selectList(booksVO);
    }

    public void insert(BooksVO booksVO) {
        booksMapper.insert(booksVO);
    }

    public void update(BooksVO booksVO) {
        booksMapper.update(booksVO);
    }

    public void delete(Long bookId) {
        booksMapper.delete(bookId);
    }
}
