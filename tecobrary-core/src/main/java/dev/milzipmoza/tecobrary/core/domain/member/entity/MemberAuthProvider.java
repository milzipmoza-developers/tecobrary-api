package dev.milzipmoza.tecobrary.core.domain.member.entity;

import lombok.Getter;

@Getter
public enum MemberAuthProvider {
    GITHUB("github");

    private final String displayName;

    MemberAuthProvider(String displayName) {
        this.displayName = displayName;
    }
}
