package kr.co.khBootAdmin.model.vo;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "EVENT_PRIZE")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventPrizeVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRIZE_ID")
    private Long prizeId;

    @Column(name = "EVENT_ID")
    private Long eventId;

    @Column(name = "PRIZE_NAME", length = 100)
    private String prizeName;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "PRIZE_DESC", length = 1000)
    private String prizeDesc;

    @Builder
    public EventPrizeVO(Long prizeId, Long eventId, String prizeName, Long quantity, String prizeDesc) {
        this.prizeId = prizeId;
        this.eventId = eventId;
        this.prizeName = prizeName;
        this.quantity = quantity;
        this.prizeDesc = prizeDesc;
    }
}