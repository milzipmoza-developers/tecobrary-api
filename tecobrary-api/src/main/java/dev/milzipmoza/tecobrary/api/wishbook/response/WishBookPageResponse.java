package dev.milzipmoza.tecobrary.api.wishbook.response;

import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookPageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class WishBookPageResponse {

    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;
    private List<WishBookDto> wishBooks;

    @Builder
    public WishBookPageResponse(int totalPages, boolean isFirstPage, boolean isLastPage, List<WishBookDto> wishBooks) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.wishBooks = wishBooks;
    }

    public static WishBookPageResponse of(WishBookPageDto wishBooks) {
        return WishBookPageResponse.builder()
                .totalPages(wishBooks.getTotalPages())
                .isFirstPage(wishBooks.isFirstPage())
                .isLastPage(wishBooks.isLastPage())
                .wishBooks(wishBooks.getWishBooks())
                .build();
    }
}
