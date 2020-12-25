package dev.milzipmoza.tecobrary.api.book.facade;

import dev.milzipmoza.tecobrary.api.book.dto.BookDeleteResponse;
import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookFacade {

    private final LibraryBookCommandService libraryBookCommandService;

    public BookEnrollResponse enroll(Long libraryBookId, String bookSerial) {
        BookDetailDto bookDetailDto = libraryBookCommandService.addBook(libraryBookId, bookSerial);
        return BookEnrollResponse.of(bookDetailDto);
    }

    public BookDeleteResponse delete(Long libraryBookId, String bookSerial) {
        BookDetailDto bookDetailDto = libraryBookCommandService.deleteBook(libraryBookId, bookSerial);
        return BookDeleteResponse.of(bookDetailDto);
    }
}
