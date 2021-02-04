package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSimpleInfoDto {

    private final String name;
    private final String profileImageUrl;
    private final MemberAuthority authority;

    @Builder
    public MemberSimpleInfoDto(String name, String profileImageUrl, MemberAuthority authority) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
    }


    public static MemberSimpleInfoDto of(Member member) {
        return MemberSimpleInfoDto.builder()
                .name(member.getName())
                .profileImageUrl(member.getProfileImageUrl())
                .authority(member.getAuthority())
                .build();
    }
}
