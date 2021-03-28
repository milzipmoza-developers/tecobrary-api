package dev.milzipmoza.tecobrary.api.book.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.book.facade.BookFacade;
import dev.milzipmoza.tecobrary.api.book.request.BookListRequest;
import dev.milzipmoza.tecobrary.api.book.response.BookDetailResponse;
import dev.milzipmoza.tecobrary.api.book.response.BookPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.GET_LIBRARY_BOOKS_SUCCESS;
import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.GET_LIBRARY_BOOK_DETAIL_SUCCESS;

@RestController
@RequiredArgsConstructor
public class CommonBookController {

    private final BookFacade bookFacade;

    @GetMapping({
            "/web/library-books",
            "/admin/library-books"
    })
    public ApiResponse<BookPageResponse> getLibraryBooks(BookListRequest request) {
        BookPageResponse response = bookFacade.getBooks(request);
        return ApiResponse.ok(GET_LIBRARY_BOOKS_SUCCESS, response);
    }

    @GetMapping({
            "/web/library-books/{id}",
            "/admin/library-books/{id}"
    })
    public ApiResponse<BookDetailResponse> getLibraryBooks(@PathVariable Long id) {
        return ApiResponse.ok(GET_LIBRARY_BOOK_DETAIL_SUCCESS, bookFacade.getBookDetail(id));
    }
}
