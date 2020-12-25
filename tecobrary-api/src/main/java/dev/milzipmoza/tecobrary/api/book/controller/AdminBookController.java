package dev.milzipmoza.tecobrary.api.book.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.book.dto.BookDeleteResponse;
import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollRequest;
import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollResponse;
import dev.milzipmoza.tecobrary.api.book.facade.BookFacade;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookSerialNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdminBookController {

    private final BookFacade bookFacade;

    @PutMapping("/admin/library-books/{libraryBookId}/books")
    public ApiResponse<BookEnrollResponse> enroll(@PathVariable Long libraryBookId,
                                                  @RequestBody BookEnrollRequest body) {
        BookEnrollResponse response = bookFacade.enroll(libraryBookId, body.getBookSerial());
        return ApiResponse.ok("장서를 성공적으로 등록하였습니다.", response);
    }

    @DeleteMapping("/admin/library-books/{libraryBookId}/books/{bookSerial}")
    public ApiResponse<BookDeleteResponse> delete(@PathVariable Long libraryBookId,
                                                  @PathVariable String bookSerial) {
        BookDeleteResponse response = bookFacade.delete(libraryBookId, bookSerial);
        return ApiResponse.ok("장서를 성공적으로 삭제하였습니다.", response);
    }

    @ExceptionHandler(BookSerialNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleEnrollException(BookSerialNotFoundException e, WebRequest request) {
        log.error("[AdminBookController] 존재하지 않는 장서 request={}, e={}", request, e);
        return ApiResponse.fail(e.getMessage());
    }
}
