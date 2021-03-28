package dev.milzipmoza.tecobrary.core.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BookPageDto {

    private final boolean isFirstPage;
    private final boolean isLastPage;
    private final int resultCounts;
    private final List<BookElementDto> books;

    @Builder
    public BookPageDto(boolean isFirstPage, boolean isLastPage, int resultCounts, List<BookElementDto> books) {
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.resultCounts = resultCounts;
        this.books = books;
    }


}
