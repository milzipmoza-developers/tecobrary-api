package dev.milzipmoza.tecobrary.api.librarybook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.librarybook.facade.BookRentFacade;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookRentResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookReturnResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/web/library-books/{libraryBookId}/books/{bookSerial}")
public class WebBookRentController {

    private final BookRentFacade bookRentFacade;

    @PostMapping("/rents")
    public ApiResponse<BookRentResponse> rentBook(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                  @PathVariable Long libraryBookId,
                                                  @PathVariable String bookSerial) {
        BookRentResponse response = bookRentFacade.rentBook(memberNumber, libraryBookId, bookSerial);
        return ApiResponse.ok("장서 대여에 성공하였습니다.", response);
    }

    @PostMapping("/return")
    public ApiResponse<BookReturnResponse> returnBook(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                      @PathVariable Long libraryBookId,
                                                      @PathVariable String bookSerial) {
        BookReturnResponse response = bookRentFacade.returnBook(memberNumber, libraryBookId, bookSerial);
        return ApiResponse.ok("장서 반납에 성공하였습니다.", response);
    }
}
