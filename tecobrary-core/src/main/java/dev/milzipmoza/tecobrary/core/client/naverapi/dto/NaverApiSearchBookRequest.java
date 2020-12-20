package dev.milzipmoza.tecobrary.core.client.naverapi.dto;

import lombok.Getter;

@Getter
public class NaverApiSearchBookRequest {

    private final String query;
    private final Long start;
    private final Long display;

    public NaverApiSearchBookRequest(String query, Long start, Long display) {
        this.query = query;
        this.start = start;
        this.display = display;
    }
}
