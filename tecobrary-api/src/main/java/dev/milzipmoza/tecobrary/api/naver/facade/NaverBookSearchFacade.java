package dev.milzipmoza.tecobrary.api.naver.facade;

import dev.milzipmoza.tecobrary.api.naver.dto.NaverBookSearchResponse;
import dev.milzipmoza.tecobrary.core.client.naverapi.NaverApiClient;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchPageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NaverBookSearchFacade {

    private final NaverApiClient client;

    public NaverBookSearchResponse searchBooks(String keyword, Long page, Long size) {
        NaverBookSearchPageDto pageBooks = client.findBooks(keyword, calculateStart(page, size), size);
        return NaverBookSearchResponse.of(pageBooks);
    }

    private long calculateStart(Long page, Long size) {
        return (page - 1) * size + 1;
    }
}
