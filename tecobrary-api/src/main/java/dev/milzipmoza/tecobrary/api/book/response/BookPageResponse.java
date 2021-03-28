package dev.milzipmoza.tecobrary.api.book.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookElementDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BookPageResponse {

    private List<BookElementDto> books;

    public BookPageResponse(List<BookElementDto> books) {
        this.books = books;
    }
}
