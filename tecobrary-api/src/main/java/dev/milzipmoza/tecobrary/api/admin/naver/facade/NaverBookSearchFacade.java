package dev.milzipmoza.tecobrary.api.admin.naver.facade;

import dev.milzipmoza.tecobrary.core.client.naverapi.NaverApiClient;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverApiSearchBookResponse;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NaverBookSearchFacade {

    private final NaverApiClient naverApiClient;

    public List<NaverBookSearchItemDto> searchBooks(String keyword, Long page, Long size) {
        NaverApiSearchBookResponse response = naverApiClient.findBooks(keyword, calculateStart(page, size), size);
        return response.getItems();
    }

    private long calculateStart(Long page, Long size) {
        return (page - 1) * size + 1;
    }
}
