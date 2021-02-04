package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfoDto {

    private final String number;
    private final String name;
    private final String email;
    private final String profileImageUrl;
    private final MemberAuthority authority;

    @Builder
    public MemberInfoDto(String number, String name, String email, String profileImageUrl, MemberAuthority authority) {
        this.number = number;
        this.name = name;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }

    public static MemberInfoDto of(Member member) {
        return MemberInfoDto.builder()
                .number(member.getNumber())
                .name(member.getName())
                .email(member.getEmail())
                .profileImageUrl(member.getProfileImageUrl())
                .authority(member.getAuthority())
                .build();
    }
}
