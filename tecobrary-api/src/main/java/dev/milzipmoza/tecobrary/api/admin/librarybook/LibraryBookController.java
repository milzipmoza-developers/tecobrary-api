package dev.milzipmoza.tecobrary.api.admin.librarybook;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.facade.LibraryBookFacade;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookAlreadyEnrolledException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.ENROLL_LIBRARY_BOOK_FAILED;
import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.ENROLL_LIBRARY_BOOK_SUCCESS;

@RestController
@RequiredArgsConstructor
@Slf4j
public class LibraryBookController {

    private final LibraryBookFacade libraryBookFacade;

    @PutMapping("/admin/library-books")
    public ApiResponse<LibraryBookEnrollResponse> enroll(@RequestBody LibraryBookEnrollRequest body) {
        return ApiResponse.ok(ENROLL_LIBRARY_BOOK_SUCCESS, libraryBookFacade.enroll(body));
    }

    @ExceptionHandler(LibraryBookAlreadyEnrolledException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleEnrollException(LibraryBookAlreadyEnrolledException e, WebRequest request) {
        log.error("[LibraryBookController][enroll] 도서 등록 실패 request={}, e={}", request, e);
        return ApiResponse.fail(ENROLL_LIBRARY_BOOK_FAILED);
    }
}
