package dev.milzipmoza.tecobrary.api.librarybook.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookElementDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LibraryBookPageResponse {

    private List<BookElementDto> books;

    public LibraryBookPageResponse(List<BookElementDto> books) {
        this.books = books;
    }
}
