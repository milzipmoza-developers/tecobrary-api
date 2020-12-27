package dev.milzipmoza.tecobrary.api.librarybook.facade;

import dev.milzipmoza.tecobrary.api.librarybook.response.BookRentResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookReturnResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.service.BookCommandService;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookQueryService;
import dev.milzipmoza.tecobrary.core.domain.rent.service.RentQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookRentFacade {

    private final LibraryBookQueryService libraryBookQueryService;
    private final RentQueryService rentQueryService;
    private final BookCommandService bookCommandService;

    public BookRentResponse rentBook(String memberNumber, Long libraryBookId, String bookSerial) {
        bookCommandService.rentBook(memberNumber, libraryBookId, bookSerial);
        BookDto bookDto = libraryBookQueryService.getBook(libraryBookId, bookSerial);
        return new BookRentResponse(bookDto);
    }

    public BookReturnResponse returnBook(String memberNumber, Long libraryBookId, String bookSerial) {
        rentQueryService.checkReturnable(memberNumber, libraryBookId, bookSerial);
        bookCommandService.returnBook(memberNumber, libraryBookId, bookSerial);
        BookDto bookDto = libraryBookQueryService.getBook(libraryBookId, bookSerial);
        return new BookReturnResponse(bookDto);
    }
}
