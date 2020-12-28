package dev.milzipmoza.tecobrary.core.domain.wishbook.dto;

import dev.milzipmoza.tecobrary.core.domain.common.dto.BookInfoDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
public class WishBookDto {

    private final Long id;
    private final BookInfoDto bookInfo;
    private final WishBookStatus wishBookStatus;

    @Builder
    public WishBookDto(Long id, BookInfoDto bookInfo, WishBookStatus wishBookStatus) {
        this.id = id;
        this.bookInfo = bookInfo;
        this.wishBookStatus = wishBookStatus;
    }

    public static WishBookDto of(WishBook savedWishBook) {
        return WishBookDto.builder()
                .id(savedWishBook.getId())
                .bookInfo(BookInfoDto.of(savedWishBook.getBookInfo()))
                .wishBookStatus(savedWishBook.getWishBookStatus())
                .build();
    }
}
