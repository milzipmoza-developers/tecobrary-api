package dev.milzipmoza.tecobrary.core.domain.book.dto;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookSummaryDto {

    private Long id;
    private String title;
    private String isbn;
    private Integer totalCount;

    @Builder
    public BookSummaryDto(Long id, String title, String isbn, Integer totalCount) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.totalCount = totalCount;
    }

    public static BookSummaryDto of(Book bookAfterAddBook) {
        return null;
    }
}
