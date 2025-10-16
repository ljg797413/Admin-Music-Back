package kr.co.khBootAdmin.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardVO {

    private Long noticeId;
    private Long noticeCodeId;

    private String noticeTitle;
    private String noticeContent;
    private String noticeCreateId;
    private String noticeUpdateId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime noticeCreateDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime noticeUpdateDate;

    private List<UploadFile> fileList = new ArrayList<>();

    @Builder
    public BoardVO(Long noticeId, Long noticeCodeId, String noticeTitle, String noticeContent, String noticeCreateId, String noticeUpdateId,
                   LocalDateTime noticeCreateDate, LocalDateTime noticeUpdateDate, List<UploadFile> fileList) {
        this.noticeId = noticeId;
        this.noticeCodeId = noticeCodeId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeCreateId = noticeCreateId;
        this.noticeUpdateId = noticeUpdateId;
        this.noticeCreateDate = noticeCreateDate;
        this.noticeUpdateDate = noticeUpdateDate;
        this.fileList = fileList;
    }
}
