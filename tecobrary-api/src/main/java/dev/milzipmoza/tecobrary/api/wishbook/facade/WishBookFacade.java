package dev.milzipmoza.tecobrary.api.wishbook.facade;

import dev.milzipmoza.tecobrary.api.wishbook.request.WishBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.wishbook.response.WishBookPageResponse;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookQueryService;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookPageDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import dev.milzipmoza.tecobrary.core.domain.wishbook.service.WishBookCommandService;
import dev.milzipmoza.tecobrary.core.domain.wishbook.service.WishBookQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WishBookFacade {

    private final LibraryBookQueryService libraryBookQueryService;
    private final WishBookQueryService wishBookQueryService;
    private final WishBookCommandService wishBookCommandService;

    public WishBookEnrollResponse enroll(String memberNumber, WishBookEnrollRequest body) {
        boolean isExistLibraryBook = libraryBookQueryService.isExistLibraryBook(body.getIsbn());
        if (isExistLibraryBook) {
            throw new IllegalArgumentException("이미 도서관에 비치되어 있는 도서입니다.");
        }
        WishBookEnrollDto enrollDto = WishBookEnrollDto.builder()
                .title(body.getTitle())
                .author(body.getAuthor())
                .isbn(body.getIsbn())
                .image(body.getImage())
                .publisher(body.getPublisher())
                .description(body.getDescription())
                .build();
        WishBookDto wishBookDto = wishBookCommandService.enroll(memberNumber, enrollDto);
        return WishBookEnrollResponse.builder()
                .id(wishBookDto.getId())
                .bookInfo(wishBookDto.getBookInfo())
                .wishBookStatus(wishBookDto.getWishBookStatus())
                .build();
    }

    public WishBookPageResponse getWishBooks(String memberNumber, int page, int size) {
        WishBookPageDto wishBooks = wishBookQueryService.getMemberPageWishBooks(memberNumber, page, size);
        return WishBookPageResponse.of(wishBooks);
    }

    public WishBookPageResponse getWishBooksByCondition(WishBookStatus status, int page, int size) {
        WishBookPageDto wishBooks = wishBookQueryService.getConditionalPageWishBooks(status, page, size);
        return WishBookPageResponse.of(wishBooks);
    }
}
