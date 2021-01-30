package dev.milzipmoza.tecobrary.security.dto;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberUpsertDto;
import dev.milzipmoza.tecobrary.security.exception.GithubOAuth2Exception;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;

import java.util.Map;
import java.util.Optional;

@Getter
public class OAuth2AttributeDto {

    private final Map<String, Object> attributes;
    private final String email;
    private final String name;
    private final String profileImageUrl;
    private final String provider;
    private final String providerKey;

    @Builder(access = AccessLevel.PRIVATE)
    private OAuth2AttributeDto(Map<String, Object> attributes, String email, String name, String profileImageUrl, String provider, String providerKey) {
        this.attributes = attributes;
        this.email = email;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.provider = provider;
        this.providerKey = providerKey;
    }

    public static OAuth2AttributeDto of(ClientRegistration clientRegistration, Map<String, Object> attributes, String email) {
        String profileImageUrl = Optional.ofNullable((String) attributes.get("avatar_url"))
                .orElseThrow(() -> new GithubOAuth2Exception("your github account something went wrong"));
        String name = Optional.ofNullable((String) attributes.get("name"))
                .orElseThrow(() -> new GithubOAuth2Exception("your github account something went wrong"));
        String providerKey = Optional.ofNullable((Integer) attributes.get("id"))
                .map(String::valueOf)
                .orElseThrow(() -> new GithubOAuth2Exception("your github account something went wrong"));
        String provider = clientRegistration.getRegistrationId();
        return OAuth2AttributeDto.builder()
                .attributes(attributes)
                .email(email)
                .name(name)
                .profileImageUrl(profileImageUrl)
                .provider(provider)
                .providerKey(providerKey)
                .build();
    }

    public MemberUpsertDto toMemberDto() {
        return MemberUpsertDto.builder()
                .name(this.name)
                .email(this.email)
                .profileImageUrl(this.profileImageUrl)
                .provider(this.provider)
                .providerKey(this.providerKey)
                .build();
    }
}
