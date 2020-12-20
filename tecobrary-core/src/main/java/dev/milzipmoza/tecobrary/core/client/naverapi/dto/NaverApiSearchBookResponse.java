package dev.milzipmoza.tecobrary.core.client.naverapi.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class NaverApiSearchBookResponse {

    private Long total;
    private Long start;
    private Long display;
    private List<NaverBookSearchItemDto> items;

    public NaverApiSearchBookResponse() {
    }

    public NaverApiSearchBookResponse(Long total, Long start, Long display, List<NaverBookSearchItemDto> items) {
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }
}
