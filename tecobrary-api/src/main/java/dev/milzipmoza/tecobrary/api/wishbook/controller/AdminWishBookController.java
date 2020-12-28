package dev.milzipmoza.tecobrary.api.wishbook.controller;

import dev.milzipmoza.tecobrary.api.ApiResponse;
import dev.milzipmoza.tecobrary.api.wishbook.facade.WishBookFacade;
import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookConditionalListRequest;
import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookStatusUpdateRequest;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookDetailResponse;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AdminWishBookController {

    private final WishBookFacade wishBookFacade;

    @GetMapping("/admin/wish-books")
    public ApiResponse<WishBookPageResponse> getWishBooks(WishBookConditionalListRequest request) {
        WishBookPageResponse response = wishBookFacade.getWishBooksByCondition(request.getStatus(), request.getPage(), request.getSize());
        return ApiResponse.ok("희망 도서 목록 조회에 성공하였습니다.", response);
    }

    @GetMapping("/admin/wish-books/{id}")
    public ApiResponse<WishBookDetailResponse> getWishBookDetail(@PathVariable Long id) {
        WishBookDetailResponse response = wishBookFacade.getWishBookDetail(id);
        return ApiResponse.ok("희망 도서 상세 조회에 성공하였습니다.", response);
    }

    @PostMapping("/admin/wish-books/{id}/confirm")
    public ApiResponse<WishBookDetailResponse> confirmWishBook(@PathVariable Long id,
                                                               @RequestBody WishBookStatusUpdateRequest body) {
        WishBookDetailResponse response = wishBookFacade.confirmWishBook(id, body.getReason());
        return ApiResponse.ok("희망 도서를 처리중 상태로 변경하였습니다.", response);
    }

    @PostMapping("/admin/wish-books/{id}/complete")
    public ApiResponse<WishBookDetailResponse> completeWishBook(@PathVariable Long id,
                                                                @RequestBody WishBookStatusUpdateRequest body) {
        WishBookDetailResponse response = wishBookFacade.completeWishBook(id, body.getReason());
        return ApiResponse.ok("희망 도서를 완료 상태로 변경하였습니다.", response);

    }

    @PostMapping("/admin/wish-books/{id}/hold")
    public ApiResponse<WishBookDetailResponse> holdWishBook(@PathVariable Long id,
                                                            @RequestBody WishBookStatusUpdateRequest body) {
        WishBookDetailResponse response = wishBookFacade.holdWishBook(id, body.getReason());
        return ApiResponse.ok("희망 도서를 보류 상태로 변경하였습니다.", response);
    }
}
