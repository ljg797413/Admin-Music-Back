package kr.co.khBootAdmin.model.vo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ArtistVO {
    private Long artistId;
    private Long followId;
    private String artistName;
    private Timestamp followDate;
    private Long followCount;
    private Long offset;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long fetch;
    private String profileImage;
    private LocalDate localDate;
    private String localDateStr;
    private String startDateStr;
    private String endDateStr;
}
