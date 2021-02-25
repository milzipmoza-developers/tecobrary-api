package dev.milzipmoza.tecobrary.core.client.naverapi;

import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverApiSearchBookResponse;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NaverApiClient {

    private final NaverApiClientDelegate delegate;

    public NaverBookSearchPageDto findBooks(String query, Long start, Long display) {
        NaverApiSearchBookResponse response = delegate.findBooks(query, start, display);
        return NaverBookSearchPageDto.of(response);
    }
}
