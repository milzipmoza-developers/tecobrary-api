package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {

    private final Long id;
    private final String number;
    private final String email;
    private final String profileImageUrl;
    private final MemberAuthority authority;

    @Builder
    public MemberDto(Long id, String number, String email, String profileImageUrl, MemberAuthority authority) {
        this.id = id;
        this.number = number;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }

    public static MemberDto of(Member it) {
        return MemberDto.builder()
                .id(it.getId())
                .number(it.getNumber())
                .email(it.getEmail())
                .profileImageUrl(it.getProfileImageUrl())
                .authority(it.getAuthority())
                .build();
    }
}
