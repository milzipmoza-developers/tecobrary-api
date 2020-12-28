package dev.milzipmoza.tecobrary.api.wishbook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.wishbook.facade.WishBookFacade;
import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookListRequest;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebWishBookController {

    private final WishBookFacade wishBookFacade;

    @GetMapping("/web/wish-books")
    public ApiResponse<WishBookPageResponse> getWishBooks(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                          WishBookListRequest request) {
        WishBookPageResponse response = wishBookFacade.getWishBooks(memberNumber, request.getPage(), request.getSize());
        return ApiResponse.ok("희망도서 목록 조회에 성공하였습니다.", response);
    }

    @PutMapping("/web/wish-books")
    public ApiResponse<WishBookEnrollResponse> enroll(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                      @RequestBody WishBookEnrollRequest body) {
        WishBookEnrollResponse response = wishBookFacade.enroll(memberNumber, body);
        return ApiResponse.ok("희망도서 등록에 성공하였습니다.", response);
    }
}
