package dev.milzipmoza.tecobrary.core.domain.wishbook.dto;

import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class WishBookPageDto {

    private final int totalPages;
    private final boolean isFirstPage;
    private final boolean isLastPage;
    private final List<WishBookDto> wishBooks;

    @Builder
    public WishBookPageDto(int totalPages, boolean isFirstPage, boolean isLastPage, List<WishBookDto> wishBooks) {
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
        this.wishBooks = wishBooks;
    }

    public static WishBookPageDto of(PageImpl<WishBook> wishBooks) {
        return WishBookPageDto.builder()
                .isFirstPage(wishBooks.isFirst())
                .isLastPage(wishBooks.isLast())
                .totalPages(wishBooks.getTotalPages())
                .wishBooks(wishBooks.getContent().stream()
                        .map(WishBookDto::of)
                        .collect(Collectors.toList()))
                .build();
    }
}
