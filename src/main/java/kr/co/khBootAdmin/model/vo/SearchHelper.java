package kr.co.khBootAdmin.model.vo;

import kr.co.khBootAdmin.util.AppConstants;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchHelper {

    private Integer searchCode;
    private String searchKeyword;
    private String searchType;
    private Long noticeCodeId;
    private int size = Integer.parseInt(AppConstants.DEFAULT_PAGE_SIZE);
    private int page = Integer.parseInt(AppConstants.DEFAULT_PAGE_NUMBER);

    @Builder
    public SearchHelper(Integer searchCode, String searchKeyword, String searchType, int size, int page, Long noticeCodeId) {
        this.searchCode = searchCode;
        this.searchKeyword = searchKeyword;
        this.searchType = searchType;
        this.size = size;
        this.page = page;
        this.noticeCodeId = noticeCodeId;
    }

}
