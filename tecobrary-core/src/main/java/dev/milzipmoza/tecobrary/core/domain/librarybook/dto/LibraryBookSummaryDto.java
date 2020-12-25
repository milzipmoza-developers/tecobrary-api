package dev.milzipmoza.tecobrary.core.domain.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LibraryBookSummaryDto {

    private Long id;
    private String title;
    private String isbn;
    private Integer totalCount;

    @Builder
    public LibraryBookSummaryDto(Long id, String title, String isbn, Integer totalCount) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.totalCount = totalCount;
    }

    public static LibraryBookSummaryDto of(LibraryBook libraryBookAfterAddBook) {
        return null;
    }
}
