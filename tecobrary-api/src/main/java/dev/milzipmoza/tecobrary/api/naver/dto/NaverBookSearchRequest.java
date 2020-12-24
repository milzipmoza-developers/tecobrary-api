package dev.milzipmoza.tecobrary.api.naver.dto;

import lombok.Getter;

@Getter
public class NaverBookSearchRequest {

    private final String keyword;
    private final Long page;
    private final Long size;

    public NaverBookSearchRequest(String keyword, Long page, Long size) {
        this.keyword = keyword;
        this.page = page;
        this.size = size;
    }
}
