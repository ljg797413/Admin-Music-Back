package kr.co.khBootAdmin.service.impl;

import kr.co.khBootAdmin.mapper.CommentReportMapper;
import kr.co.khBootAdmin.model.vo.CommentReportVO;
import kr.co.khBootAdmin.service.CommentReportService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CommentReportServiceImpl implements CommentReportService {

    private final CommentReportMapper commentReportMapper;

    @Override
    public List<CommentReportVO> getReportedComments() {
        return commentReportMapper.selectReportedComments();
    }
}
