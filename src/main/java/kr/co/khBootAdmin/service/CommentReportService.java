package kr.co.khBootAdmin.service;

import kr.co.khBootAdmin.model.vo.CommentReportVO;

import java.util.List;

public interface CommentReportService {

    public List<CommentReportVO> getReportedComments();
}
