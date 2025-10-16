package kr.co.khBootAdmin.mapper;

import kr.co.khBootAdmin.model.vo.CommentReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentReportMapper {


    List<CommentReportVO> selectReportedComments();
}
