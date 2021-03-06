package dev.milzipmoza.tecobrary.api.naver.dto;

import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class NaverBookSearchResponse {

    private final Long total;
    private final Long start;
    private final Long display;
    private final List<NaverBookSearchItemDto> items;

    @Builder
    public NaverBookSearchResponse(Long total, Long start, Long display, List<NaverBookSearchItemDto> items) {
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }
}
