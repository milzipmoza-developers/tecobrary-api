package dev.milzipmoza.tecobrary.api.book.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollRequest;
import dev.milzipmoza.tecobrary.api.book.dto.BookEnrollResponse;
import dev.milzipmoza.tecobrary.api.book.facade.BookFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
