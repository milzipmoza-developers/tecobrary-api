package dev.milzipmoza.tecobrary.api.member.request;

import lombok.Getter;

@Getter
public class MemberPageRequest {
    private final int page;
    private final int size;

    public MemberPageRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
