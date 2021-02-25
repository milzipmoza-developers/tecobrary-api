package dev.milzipmoza.tecobrary.core.client.naverapi.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class NaverBookSearchPageDto {

    private final Long total;
    private final Long start;
    private final Long display;
    private final List<NaverBookSearchItemDto> items;

    @Builder
    public NaverBookSearchPageDto(Long total, Long start, Long display, List<NaverBookSearchItemDto> items) {
        this.total = total;
        this.start = start;
        this.display = display;
        this.items = items;
    }

    public static NaverBookSearchPageDto of(NaverApiSearchBookResponse response) {
        return NaverBookSearchPageDto.builder()
                .total(response.getTotal())
                .start(response.getStart())
                .display(response.getDisplay())
                .items(response.getItems())
                .build();
    }
}
