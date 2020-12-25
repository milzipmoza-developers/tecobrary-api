package dev.milzipmoza.tecobrary.api.book.facade;

import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookEnrollDto;
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
        libraryBookQueryService.existsById(libraryBookId);
        BookEnrollDto bookEnrollDto = libraryBookCommandService.addBook(libraryBookId, bookSerial);
        return BookEnrollResponse.of(bookEnrollDto);
    }
}
