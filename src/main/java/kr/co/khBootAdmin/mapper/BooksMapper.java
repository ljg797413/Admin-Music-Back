package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.vo.BooksVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BooksMapper {

    List<BooksVO> selectList(BooksVO booksVO);
    void insert(BooksVO booksVO);
    void update(BooksVO booksVO);
    void delete(Long bookId);
}
