package dev.milzipmoza.tecobrary.api.librarybook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.librarybook.facade.BookFacade;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookRentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebBookController {

    private final BookFacade bookFacade;

    @PostMapping("/web/library-books/{libraryBookId}/books/{bookSerial}/rents")
    public ApiResponse<BookRentResponse> rentBook(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                  @PathVariable Long libraryBookId,
                                                  @PathVariable String bookSerial) {
        BookRentResponse response = bookFacade.rentBook(memberNumber, libraryBookId, bookSerial);
        return ApiResponse.ok("장서 대여에 성공하였습니다.", response);
    }
}
