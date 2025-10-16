package kr.co.khBootAdmin.model.vo;


import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Setter
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrackVO {
    private String trackId;
    private String trackName;
    private String trackArtist;
    private Long playCount;
    private Long offset;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long fetch;
    private String trackImageUrl;
    private LocalDate localDate;
    private String localDateStr;
    private String startDateStr;
    private String endDateStr;

}
