package dev.milzipmoza.tecobrary.security.dto;

import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberUpsertDto;
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
                .orElse("");
        String name = Optional.ofNullable((String) attributes.get("name"))
                .orElse("");
        String providerKey = Optional.ofNullable((String) attributes.get("id"))
                .orElseThrow(() -> new IllegalArgumentException("회원가입 불가능한 계정입니다."));
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
                .profileImageUrl(this.profileImageUrl)
                .provider(this.provider)
                .providerKey(this.providerKey)
                .build();
    }
}
