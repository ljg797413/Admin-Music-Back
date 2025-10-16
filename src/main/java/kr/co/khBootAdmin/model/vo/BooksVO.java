package kr.co.khBootAdmin.model.vo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class BooksVO {
    private Long bookId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private int price;
    private LocalDate publishedDate;
    private String createdBy;
    private LocalDate createdAt;
    private String updatedBy;
    private LocalDate updatedAt;
}

