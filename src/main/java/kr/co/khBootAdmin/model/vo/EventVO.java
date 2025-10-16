package kr.co.khBootAdmin.model.vo;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ADMIN_EVENT") // 이벤트 테이블
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventVO {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EVENT_ID")
    private Long eventId;

    @Column(name = "EVENT_CODE", nullable = false)
    private Long eventCode;

    @Column(name = "EVENT_TITLE", nullable = false, length = 1000)
    private String eventTitle;

    @Lob
    @Column(name = "EVENT_CONTENT")
    private String eventContent;

    @Column(name = "EVENT_CREATE_ID", nullable = false, length = 30)
    private String eventCreateId;

    @Column(name = "EVENT_CREATE_DATE", nullable = false)
    private LocalDateTime eventCreateDate;

    @Column(name = "EVENT_UPDATE_ID", length = 30)
    private String eventUpdateId;

    @Column(name = "EVENT_UPDATE_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // 날짜 형식 지정
    private LocalDateTime eventUpdateDate;

    @Column(name = "EVENT_START_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // 날짜 형식 지정
    private LocalDateTime eventStartDate;

    @Column(name = "EVENT_END_DATE", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")  // 날짜 형식 지정
    private LocalDateTime eventEndDate;

    // 이벤트에 포함되는 경품 목록
//    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<EventPrizeVO> prizeList;  // 이벤트와 연결된 경품 목록


    @Builder
    public EventVO(Long eventId, Long eventCode, String eventTitle, String eventContent, String eventCreateId, LocalDateTime eventCreateDate, String eventUpdateId, LocalDateTime eventUpdateDate, LocalDateTime eventStartDate, LocalDateTime eventEndDate, List<EventPrizeVO> prizeList) {
        this.eventId = eventId;
        this.eventCode = eventCode;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventCreateId = eventCreateId;
        this.eventCreateDate = eventCreateDate;
        this.eventUpdateId = eventUpdateId;
        this.eventUpdateDate = eventUpdateDate;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        //this.prizeList = prizeList;
    }
}