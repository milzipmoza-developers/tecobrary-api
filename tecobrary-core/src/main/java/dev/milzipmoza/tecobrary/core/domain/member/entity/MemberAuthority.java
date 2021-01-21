package dev.milzipmoza.tecobrary.core.domain.member.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MemberAuthority {
    BANNED("금지회원", "ROLE_BANNED"),
    UNAUTHORIZED("권한없음", "ROLE_UNAUTHORIZED"),
    AUTHORIZED("인증됨", "ROLE_AUTHORIZED"),
    MANAGER("관리자", "ROLE_MANAGER"),
    KING("왕", "ROLE_KING");

    private final String displayName;
    private final String securityRoleName;
}
