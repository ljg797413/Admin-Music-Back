package kr.co.khBootAdmin.model.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class EventRequest {

    private Long eventId;          // eventId: Long으로 설정, 프론트에서 보내는 값은 number
    private Long eventCode;        // eventCode: Long으로 설정
    private String eventTitle;     // eventTitle: String
    private String eventContent;   // eventContent: String
    private String eventCreateId;  // eventCreateId: String
    private LocalDateTime eventCreateDate; // eventCreateDate: String (프론트에서 보내는 날짜 형식으로 받음)
    private String eventUpdateId;  // eventUpdateId: String
    private LocalDateTime eventUpdateDate; // eventUpdateDate: String
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // 날짜 형식 지정
    private LocalDateTime eventStartDate;  // eventStartDate: String (프론트에서 보내는 날짜 형식으로 받음)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // 날짜 형식 지정
    private LocalDateTime eventEndDate;    // eventEndDate: String (프론트에서 보내는 날짜 형식으로 받음)
    private String prizeName;
    private Long quantity;

    // 검색용 필드
    private Long size;                // 페이지 사이즈
    private Long page;                // 페이지 번호
    private Long searchCode;          // 검색 코드
    private String searchType;        // 검색 타입
    private String searchKeyword;     // 검색 키워드
}






//private Long id;
//private Long eventCodeId; // noticeCodeId -> eventCodeId
//private String eventTitle; // noticeTitle -> eventTitle
//private String eventContent; // noticeContent -> eventContent
//private String eventCreateId; // noticeCreateId -> eventCreateId
//private String eventUpdateId; // noticeUpdateId -> eventUpdateId
//private Long[] files; // 파일 관련 부분은 그대로 두었으므로 변경 안 함
//private String fileTarget; // 파일 관련 부분은 그대로 두었으므로 변경 안 함
//private List<UploadFile> fileList; // 파일 관련 부분은 그대로 두었으므로 변경 안 함
//
//// 검색용
//private Long size;
//private Long page;
//private Long searchCode;
//private String searchType;
//private String searchKeyword;
//
//// 이벤트 게시판용
//private String startDate; // 시작일
//private String endDate; // 종료일