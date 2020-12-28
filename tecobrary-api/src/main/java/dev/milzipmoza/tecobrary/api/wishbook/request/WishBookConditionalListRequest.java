package dev.milzipmoza.tecobrary.api.wishbook.request;

import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import lombok.Getter;

@Getter
public class WishBookConditionalListRequest {

    private final int page;
    private final int size;
    private final WishBookStatus status;

    public WishBookConditionalListRequest(int page, int size, WishBookStatus status) {
        this.page = page;
        this.size = size;
        this.status = status;
    }
}
