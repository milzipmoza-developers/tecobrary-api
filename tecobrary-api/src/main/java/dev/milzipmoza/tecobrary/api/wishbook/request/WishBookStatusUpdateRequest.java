package dev.milzipmoza.tecobrary.api.wishbook.request;

import lombok.Getter;

@Getter
public class WishBookStatusUpdateRequest {

    private final String reason;

    public WishBookStatusUpdateRequest(String reason) {
        this.reason = reason;
    }
}
