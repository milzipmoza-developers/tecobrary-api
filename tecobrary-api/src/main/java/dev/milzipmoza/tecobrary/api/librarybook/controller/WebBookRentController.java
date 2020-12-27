package dev.milzipmoza.tecobrary.api.librarybook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.librarybook.facade.BookRentFacade;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookRentResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.BookReturnResponse;
import dev.milzipmoza.tecobrary.core.domain.rent.exception.RentNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Slf4j
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

    @ExceptionHandler(RentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleDeleteException(RentNotFoundException e, WebRequest request) {
        log.warn("[WebBookRentController] 대여 내역 검색 실패 request={}, e={}", request, e);
        return ApiResponse.fail(e.getMessage());
    }
}
