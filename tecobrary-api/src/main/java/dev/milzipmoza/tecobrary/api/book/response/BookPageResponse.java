package dev.milzipmoza.tecobrary.api.book.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookElementDto;
import dev.milzipmoza.tecobrary.core.domain.book.dto.BookPageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookPageResponse {

    private boolean isFirstPage;
    private boolean isLastPage;
    private int resultCounts;
    private List<BookElementDto> books;

    @Builder
    private BookPageResponse(boolean isFirstPage, boolean isLastPage, int resultCounts, List<BookElementDto> books) {
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.resultCounts = resultCounts;
        this.books = books;
    }

    public static BookPageResponse of(BookPageDto pageDto) {
        return BookPageResponse.builder()
                .isFirstPage(pageDto.isFirstPage())
                .isLastPage(pageDto.isLastPage())
                .resultCounts(pageDto.getResultCounts())
                .books(pageDto.getBooks())
                .build();
    }
}
