package dev.milzipmoza.tecobrary.api.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookSummaryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookDeleteResponse {

    private LibraryBookSummaryDto libraryBook;
    private List<BookDto> books;

    public BookDeleteResponse(LibraryBookSummaryDto libraryBook, List<BookDto> books) {
        this.libraryBook = libraryBook;
        this.books = books;
    }

    public static BookDeleteResponse of(BookDetailDto enrollDto) {
        return new BookDeleteResponse(enrollDto.getLibraryBook(), enrollDto.getBooks());
    }
}
