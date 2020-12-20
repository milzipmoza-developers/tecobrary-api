package dev.milzipmoza.tecobrary.core.client.naverapi;

import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverApiSearchBookResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NaverApiControllerTest {

    @Autowired
    private NaverApiController naverApiController;

    @Test
    @DisplayName("네이버 API 책 검색 요청, 응답")
    void findBooks() {
        NaverApiSearchBookResponse response = naverApiController.findBooks("JPA 프로그래밍", 1L, 10L);

        assertThat(response.getStart()).isEqualTo(1L);
        assertThat(response.getDisplay()).isEqualTo(10L);
        assertThat(response.getItems()).isNotNull();
    }
}