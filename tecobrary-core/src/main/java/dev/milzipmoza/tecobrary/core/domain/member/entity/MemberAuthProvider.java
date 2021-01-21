package dev.milzipmoza.tecobrary.core.domain.member.entity;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum MemberAuthProvider {
    GITHUB("github", "github");

    private final String displayName;
    private final String oAuth2Name;

    MemberAuthProvider(String displayName, String oAuth2Name) {
        this.displayName = displayName;
        this.oAuth2Name = oAuth2Name;
    }

    public static MemberAuthProvider of(String oAuth2Name) {
        return Arrays.stream(values())
                .filter(it -> it.oAuth2Name.equals(oAuth2Name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원 준비중인 서비스 계정입니다."));
    }
}
