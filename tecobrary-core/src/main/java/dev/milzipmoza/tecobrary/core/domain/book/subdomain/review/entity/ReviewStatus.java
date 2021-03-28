package dev.milzipmoza.tecobrary.core.domain.book.subdomain.review.entity;

import lombok.Getter;

@Getter
public enum ReviewStatus {
    PUBLIC("공개"),
    PRIVATE("비공개"),
    BANNED("금지"),
    DELETED("삭제");

    private final String displayName;

    ReviewStatus(String displayName) {
        this.displayName = displayName;
    }
}
