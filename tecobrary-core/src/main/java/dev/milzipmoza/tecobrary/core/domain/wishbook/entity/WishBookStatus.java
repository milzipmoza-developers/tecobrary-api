package dev.milzipmoza.tecobrary.core.domain.wishbook.entity;

import lombok.Getter;

@Getter
public enum WishBookStatus {
    REQUESTED("신청됨"),
    PROCESSING("처리중"),
    COMPLETED("처리완료"),
    HELD("보류됨");

    private final String displayName;

    WishBookStatus(String displayName) {
        this.displayName = displayName;
    }
}
