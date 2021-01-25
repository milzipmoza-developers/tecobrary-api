package dev.milzipmoza.tecobrary.core.domain.member.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberUpsertDto {

    private final String name;
    private final String email;
    private final String profileImageUrl;
    private final String provider;
    private final String providerKey;

    @Builder
    public MemberUpsertDto(String name, String email, String profileImageUrl, String provider, String providerKey) {
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.provider = provider;
        this.providerKey = providerKey;
    }
}
