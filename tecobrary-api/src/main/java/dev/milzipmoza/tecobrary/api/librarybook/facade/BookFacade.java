package dev.milzipmoza.tecobrary.api.librarybook.facade;

import dev.milzipmoza.tecobrary.api.librarybook.response.BookDeleteResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookCommandService;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookFacade {

    private final LibraryBookQueryService libraryBookQueryService;
    private final LibraryBookCommandService libraryBookCommandService;

    public BookEnrollResponse enroll(Long libraryBookId, String bookSerial) {
        libraryBookCommandService.addBook(libraryBookId, bookSerial);
        BookDetailDto bookDetailDto = libraryBookQueryService.getBookDetail(libraryBookId);
        return BookEnrollResponse.of(bookDetailDto);
    }

    public BookDeleteResponse delete(Long libraryBookId, String bookSerial) {
        libraryBookCommandService.deleteBook(libraryBookId, bookSerial);
        BookDetailDto bookDetailDto = libraryBookQueryService.getBookDetail(libraryBookId);
        return BookDeleteResponse.of(bookDetailDto);
    }
}
