package dev.milzipmoza.tecobrary.core.client.github.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GithubEmailDto {

    private String email;
    private Boolean primary;
    private Boolean verified;

    public GithubEmailDto(String email, Boolean primary, Boolean verified) {
        this.email = email;
        this.primary = primary;
        this.verified = verified;
    }
}
