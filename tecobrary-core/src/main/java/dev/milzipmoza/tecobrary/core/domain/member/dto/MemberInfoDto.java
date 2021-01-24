package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberInfoDto {

    private final String name;
    private final String profileImageUrl;
    private final MemberAuthority authority;

    @Builder
    public MemberInfoDto(String name, String profileImageUrl, MemberAuthority authority) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }


    public static MemberInfoDto of(Member member) {
        return MemberInfoDto.builder()
                .name(member.getName())
                .profileImageUrl(member.getProfileImageUrl())
                .authority(member.getAuthority())
                .build();
    }
}
