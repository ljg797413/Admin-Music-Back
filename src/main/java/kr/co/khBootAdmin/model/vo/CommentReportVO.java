package kr.co.khBootAdmin.model.vo;

import kr.co.khBootAdmin.model.User;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "COMMENT_REPORT")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentReportVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REPORT_ID")
    private Long reportId;

    @Column(name = "REPORT_REASON", nullable = false, length = 500)
    private String reportReason;

    @Column(name = "REPORT_DATE", nullable = false)
    private LocalDateTime reportDate;

    // 신고자 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false) // 신고자
    private User reporter;

    // 댓글 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMENT_ID", nullable = false)
    private CommentsVO comment;

    // 생성자
    @Builder
    public CommentReportVO(Long reportId, String reportReason, LocalDateTime reportDate, User reporter, CommentsVO comment) {
        this.reportId = reportId;
        this.reportReason = reportReason;
        this.reportDate = reportDate;
        this.reporter = reporter;
        this.comment = comment;
    }
}
