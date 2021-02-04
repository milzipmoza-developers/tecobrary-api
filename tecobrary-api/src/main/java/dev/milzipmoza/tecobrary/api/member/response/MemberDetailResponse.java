package dev.milzipmoza.tecobrary.api.member.response;


import dev.milzipmoza.tecobrary.core.domain.member.dto.MemberDetailDto;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthority;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberDetailResponse {

    private final Long id;
    private final String number;
    private final String email;
    private final String profileImageUrl;
    private final MemberAuthority authority;
    private final MemberAuthProvider authProvider;
    private final String authKey;

    @Builder
    public MemberDetailResponse(Long id, String number, String email, String profileImageUrl, MemberAuthority authority, MemberAuthProvider authProvider, String authKey) {
        this.id = id;
        this.number = number;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.authority = authority;
        this.authProvider = authProvider;
        this.authKey = authKey;
    }

    public static MemberDetailResponse of(MemberDetailDto member) {
        return MemberDetailResponse.builder()
                .id(member.getId())
                .number(member.getNumber())
                .email(member.getEmail())
                .profileImageUrl(member.getProfileImageUrl())
                .authority(member.getAuthority())
                .authProvider(member.getAuthProvider())
                .authKey(member.getAuthKey())
                .build();
    }
}
