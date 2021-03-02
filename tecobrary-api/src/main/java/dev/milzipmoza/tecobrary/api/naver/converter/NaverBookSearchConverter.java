package dev.milzipmoza.tecobrary.api.naver.converter;

import dev.milzipmoza.tecobrary.api.naver.dto.NaverBookSearchResponse;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchItemDto;
import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverBookSearchPageDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class NaverBookSearchConverter {

    private static final String ISBN_DELIMITER = " ";
    private static final int ISBN_INDEX = 1;

    public NaverBookSearchResponse convert(NaverBookSearchPageDto pageDto) {
        return NaverBookSearchResponse.builder()
                .total(pageDto.getTotal())
                .start(pageDto.getStart())
                .display(pageDto.getDisplay())
                .items(pageDto.getItems().stream()
                        .map(it -> NaverBookSearchItemDto.builder()
                                .title(it.getTitle())
                                .author(it.getAuthor())
                                .publisher(it.getPublisher())
                                .description(it.getDescription())
                                .image(it.getImage())
                                .isbn(extractIsbn(it))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    private String extractIsbn(NaverBookSearchItemDto it) {
        return it.getIsbn().split(ISBN_DELIMITER)[ISBN_INDEX];
    }
}
