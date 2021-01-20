package dev.milzipmoza.tecobrary.core.client.github;

import dev.milzipmoza.tecobrary.core.client.github.dto.GithubEmailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "github-api", url = "${github-api.url}")
public interface GithubApiClientDelegate {

    @GetMapping("/user/emails")
    List<GithubEmailDto> getEmails(@RequestHeader("Authorization") String accessToken);
}
