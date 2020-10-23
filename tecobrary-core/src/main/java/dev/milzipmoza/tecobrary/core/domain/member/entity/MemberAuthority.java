package dev.milzipmoza.tecobrary.core.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberAuthority {
    BANNED("금지회원"),
    UNAUTHORIZED("권한없음"),
    AUTHORIZED("인증됨"),
    MANAGER("관리자"),
    KING("왕");

    private final String displayName;
}
