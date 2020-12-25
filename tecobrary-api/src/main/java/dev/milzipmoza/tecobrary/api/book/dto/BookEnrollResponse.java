package dev.milzipmoza.tecobrary.api.book.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookSummaryDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookEnrollResponse {

    private LibraryBookSummaryDto libraryBook;
    private List<BookDto> books;

    public BookEnrollResponse(LibraryBookSummaryDto libraryBook, List<BookDto> books) {
        this.libraryBook = libraryBook;
        this.books = books;
    }

    public static BookEnrollResponse of(BookEnrollDto enrollDto) {
        return new BookEnrollResponse(enrollDto.getLibraryBook(), enrollDto.getBooks());
    }
}
