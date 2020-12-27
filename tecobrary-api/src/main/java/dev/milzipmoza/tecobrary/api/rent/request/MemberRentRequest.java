package dev.milzipmoza.tecobrary.api.rent.request;

import lombok.Getter;

@Getter
public class MemberRentRequest {

    private final int page;
    private final int size;

    public MemberRentRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
