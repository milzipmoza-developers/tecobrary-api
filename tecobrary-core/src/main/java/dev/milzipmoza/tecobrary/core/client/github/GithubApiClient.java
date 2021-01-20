package dev.milzipmoza.tecobrary.core.client.github;

import dev.milzipmoza.tecobrary.core.client.ClientException;
import dev.milzipmoza.tecobrary.core.client.github.dto.GithubEmailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GithubApiClient {

    private final GithubApiClientDelegate delegate;

    public String getPrimaryEmail(String accessToken) {
        try {
            List<GithubEmailDto> emails = delegate.getEmails(String.format("token %s", accessToken));
            GithubEmailDto emailDto = emails.stream()
                    .filter(GithubEmailDto::getPrimary)
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Github 이메일 정보가 존재하지 않습니다"));
            return emailDto.getEmail();
        } catch (Exception e) {
            throw new ClientException("요청에 실패하였습니다.");
        }
    }
}
