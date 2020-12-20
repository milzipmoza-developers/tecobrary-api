package dev.milzipmoza.tecobrary.core.client.naverapi;

import dev.milzipmoza.tecobrary.core.client.naverapi.dto.NaverApiSearchBookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${naver-api.name}", url = "${naver-api.url}", configuration = NaverApiConfiguration.class)
public interface NaverApiClient {

    @GetMapping("/v1/search/book.json")
    NaverApiSearchBookResponse findBooks(@RequestParam("query") String query,
                                         @RequestParam("start") Long start,
                                         @RequestParam("display") Long display);
}
