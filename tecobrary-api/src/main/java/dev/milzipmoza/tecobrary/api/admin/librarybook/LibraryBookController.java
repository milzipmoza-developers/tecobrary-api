package dev.milzipmoza.tecobrary.api.admin.librarybook;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.facade.LibraryBookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static dev.milzipmoza.tecobrary.api.ApiResponseMessage.ENROLL_LIBRARY_BOOK_SUCCESS;

@RestController
@RequiredArgsConstructor
public class LibraryBookController {

    private final LibraryBookFacade libraryBookFacade;

    @PutMapping("/admin/library-books")
    public ApiResponse<LibraryBookEnrollResponse> enroll(@RequestBody LibraryBookEnrollRequest body) {
        return ApiResponse.ok(ENROLL_LIBRARY_BOOK_SUCCESS, libraryBookFacade.enroll(body));
    }
}
