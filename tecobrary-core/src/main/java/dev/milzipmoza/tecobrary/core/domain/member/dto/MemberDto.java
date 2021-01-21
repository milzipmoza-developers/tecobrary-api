package dev.milzipmoza.tecobrary.core.domain.member.dto;

import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDto {

    private final String name;
    private final String profileImageUrl;
    private final MemberAuthority role;

    @Builder
    public MemberDto(String name, String profileImageUrl, MemberAuthority role) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.role = role;
    }


    public static MemberDto of(Member member) {
        return MemberDto.builder()
                .name(member.getName())
                .profileImageUrl(member.getProfileImageUrl())
                .role(member.getAuthority())
                .build();
    }
}
