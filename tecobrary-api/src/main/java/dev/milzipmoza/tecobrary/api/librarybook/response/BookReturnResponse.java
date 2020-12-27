package dev.milzipmoza.tecobrary.api.librarybook.response;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookReturnResponse {

    private BookDto book;

    public BookReturnResponse(BookDto book) {
        this.book = book;
    }
}
