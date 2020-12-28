package dev.milzipmoza.tecobrary.api.wishbook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.wishbook.facade.WishBookFacade;
import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookEnrollResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebWishBookController {

    private final WishBookFacade wishBookFacade;

    @PutMapping("/web/wish-books")
    public ApiResponse<WishBookEnrollResponse> enroll(@RequestHeader("X-TECOBRARY-MEMBER-NO") String memberNumber,
                                                      @RequestBody WishBookEnrollRequest body) {
        WishBookEnrollResponse response = wishBookFacade.enroll(memberNumber, body);
        return ApiResponse.ok("희망도서 등록에 성공하였습니다.", response);
    }
}
