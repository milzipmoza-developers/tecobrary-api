package dev.milzipmoza.tecobrary.api.librarybook;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.LIBRARY_BOOK_NOT_FOUND;

@RestControllerAdvice
@Slf4j
public class LibraryBookControllerAdvice {

    @ExceptionHandler(LibraryBookNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleNotFoundException(LibraryBookNotFoundException e, WebRequest request) {
        log.error("[LibraryBookController] 도서 검색 실패 request={}, e={}", request, e);
        return ApiResponse.fail(LIBRARY_BOOK_NOT_FOUND);
    }
}
