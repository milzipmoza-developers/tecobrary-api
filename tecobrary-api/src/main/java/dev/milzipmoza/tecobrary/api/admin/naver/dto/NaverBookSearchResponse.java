package dev.milzipmoza.tecobrary.api.admin.naver.dto;

import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import lombok.Getter;

import java.util.List;

@Getter
public class NaverBookSearchResponse {

    private final List<NaverBookSearchItemDto> items;

    public NaverBookSearchResponse(List<NaverBookSearchItemDto> items) {
        this.items = items;
    }
}
