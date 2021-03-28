package dev.milzipmoza.tecobrary.api.book.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.book.facade.BookFacade;
import dev.milzipmoza.tecobrary.api.book.request.BookEnrollRequest;
import dev.milzipmoza.tecobrary.api.book.request.BookUpdateRequest;
import dev.milzipmoza.tecobrary.api.book.response.BookEnrollResponse;
import dev.milzipmoza.tecobrary.api.book.response.BookUpdateResponse;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookAlreadyEnrolledException;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookDeletedFailedException;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookUpdateFailedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AdminBookController {

    private final BookFacade bookFacade;

    @PutMapping("/admin/library-books")
    public ApiResponse<BookEnrollResponse> enroll(@RequestBody BookEnrollRequest body) {
        return ApiResponse.ok(ENROLL_LIBRARY_BOOK_SUCCESS, bookFacade.enroll(body));
    }

    @PostMapping("/admin/library-books")
    public ApiResponse<BookUpdateResponse> update(@RequestBody BookUpdateRequest body) {
        return ApiResponse.ok(UPDATE_LIBRARY_BOOK_SUCCESS, bookFacade.update(body));
    }

    @DeleteMapping("/admin/library-books/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        bookFacade.delete(id);
        return ApiResponse.ok(DELETE_LIBRARY_BOOK_SUCCESS);
    }

    @ExceptionHandler(BookAlreadyEnrolledException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleEnrollException(BookAlreadyEnrolledException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 등록 실패 request={}, e={}", request, e);
        return ApiResponse.fail(ENROLL_LIBRARY_BOOK_FAILED);
    }

    @ExceptionHandler(BookUpdateFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleUpdateException(BookUpdateFailedException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 업데이트 실패 request={}, e={}", request, e);
        return ApiResponse.fail(UPDATE_LIBRARY_BOOK_FAILED);
    }

    @ExceptionHandler(BookDeletedFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleDeleteException(BookDeletedFailedException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 삭제 실패 request={}, e={}", request, e);
        return ApiResponse.fail(LIBRARY_BOOK_NOT_FOUND);
    }
}
