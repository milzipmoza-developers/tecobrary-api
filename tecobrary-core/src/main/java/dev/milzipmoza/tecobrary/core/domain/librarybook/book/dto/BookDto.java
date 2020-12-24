package dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.BookStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookDto {

    private final String bookSerial;
    private final BookStatus bookStatus;

    @Builder
    public BookDto(String bookSerial, BookStatus bookStatus) {
        this.bookSerial = bookSerial;
        this.bookStatus = bookStatus;
    }
}
