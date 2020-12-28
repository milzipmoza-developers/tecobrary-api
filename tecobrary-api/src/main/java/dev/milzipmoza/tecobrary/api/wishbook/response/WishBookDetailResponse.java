package dev.milzipmoza.tecobrary.api.wishbook.response;

import dev.milzipmoza.tecobrary.core.domain.common.dto.BookInfoDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WishBookDetailResponse {

    private Long id;
    private BookInfoDto bookInfo;
    private WishBookStatus wishBookStatus;

    @Builder
    public WishBookDetailResponse(Long id, BookInfoDto bookInfo, WishBookStatus wishBookStatus) {
        this.id = id;
        this.bookInfo = bookInfo;
        this.wishBookStatus = wishBookStatus;
    }

    public static WishBookDetailResponse of(WishBookDto wishBook) {
        return WishBookDetailResponse.builder()
                .id(wishBook.getId())
                .bookInfo(wishBook.getBookInfo())
                .wishBookStatus(wishBook.getWishBookStatus())
                .build();
    }
}
