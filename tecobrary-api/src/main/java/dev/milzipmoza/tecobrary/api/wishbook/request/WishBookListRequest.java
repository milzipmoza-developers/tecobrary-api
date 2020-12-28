package dev.milzipmoza.tecobrary.api.wishbook.request;

import lombok.Getter;

@Getter
public class WishBookListRequest {

    private final int page;
    private final int size;

    public WishBookListRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
