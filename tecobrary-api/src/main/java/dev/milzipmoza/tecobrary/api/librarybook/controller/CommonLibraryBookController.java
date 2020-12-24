package dev.milzipmoza.tecobrary.api.librarybook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.librarybook.dto.LibraryBookDetailResponse;
import dev.milzipmoza.tecobrary.api.librarybook.dto.LibraryBookListRequest;
import dev.milzipmoza.tecobrary.api.librarybook.dto.LibraryBookListResponse;
import dev.milzipmoza.tecobrary.api.librarybook.facade.LibraryBookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.GET_LIBRARY_BOOKS_SUCCESS;
import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.GET_LIBRARY_BOOK_DETAIL_SUCCESS;

@RestController
@RequiredArgsConstructor
public class CommonLibraryBookController {

    private final LibraryBookFacade libraryBookFacade;

    @GetMapping({
            "/web/library-books",
            "/admin/library-books"
    })
    public ApiResponse<LibraryBookListResponse> getLibraryBooks(LibraryBookListRequest request) {
        LibraryBookListResponse response = libraryBookFacade.getBooks(request);
        return ApiResponse.ok(GET_LIBRARY_BOOKS_SUCCESS, response);
    }

    @GetMapping({
            "/web/library-books/{id}",
            "/admin/library-books/{id}"
    })
    public ApiResponse<LibraryBookDetailResponse> getLibraryBooks(@PathVariable Long id) {
        return ApiResponse.ok(GET_LIBRARY_BOOK_DETAIL_SUCCESS, libraryBookFacade.getBookDetail(id));
    }
}
