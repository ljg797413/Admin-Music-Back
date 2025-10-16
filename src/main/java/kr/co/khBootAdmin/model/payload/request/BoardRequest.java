package kr.co.khBootAdmin.model.payload.request;

import kr.co.khBootAdmin.model.vo.UploadFile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BoardRequest {

    private Long id;
    private Long noticeCodeId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeCreateId;
    private String noticeUpdateId;
    private Long[] files;
    private String fileTarget;
    private List<UploadFile> fileList;

    // 검색용
    private Long size;
    private Long page;
    private Long searchCode;
    private String searchType;
    private String searchKeyword;

    // 이벤트 게시판용
    private String startDate;
    private String endDate;
}

