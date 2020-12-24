package dev.milzipmoza.tecobrary.api.admin.librarybook;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookUpdateRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookUpdateResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.facade.LibraryBookFacade;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookAlreadyEnrolledException;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookDeletedFailedException;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookUpdateFailedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LibraryBookController {

    private final LibraryBookFacade libraryBookFacade;

    @PutMapping("/admin/library-books")
    public ApiResponse<LibraryBookEnrollResponse> enroll(@RequestBody LibraryBookEnrollRequest body) {
        return ApiResponse.ok(ENROLL_LIBRARY_BOOK_SUCCESS, libraryBookFacade.enroll(body));
    }

    @PostMapping("/admin/library-books")
    public ApiResponse<LibraryBookUpdateResponse> update(@RequestBody LibraryBookUpdateRequest body) {
        return ApiResponse.ok(UPDATE_LIBRARY_BOOK_SUCCESS, libraryBookFacade.update(body));
    }

    @DeleteMapping("/admin/library-books/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        libraryBookFacade.delete(id);
        return ApiResponse.ok(DELETE_LIBRARY_BOOK_SUCCESS);
    }

    @ExceptionHandler(LibraryBookAlreadyEnrolledException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleEnrollException(LibraryBookAlreadyEnrolledException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 등록 실패 request={}, e={}", request, e);
        return ApiResponse.fail(ENROLL_LIBRARY_BOOK_FAILED);
    }

    @ExceptionHandler(LibraryBookUpdateFailedException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleUpdateException(LibraryBookUpdateFailedException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 업데이트 실패 request={}, e={}", request, e);
        return ApiResponse.fail(UPDATE_LIBRARY_BOOK_FAILED);
    }

    @ExceptionHandler(LibraryBookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleNotFoundException(LibraryBookNotFoundException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 검색 실패 request={}, e={}", request, e);
        return ApiResponse.fail(LIBRARY_BOOK_NOT_FOUND);
    }

    @ExceptionHandler(LibraryBookDeletedFailedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleDeleteException(LibraryBookDeletedFailedException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 삭제 실패 request={}, e={}", request, e);
        return ApiResponse.fail(LIBRARY_BOOK_NOT_FOUND);
    }
}
