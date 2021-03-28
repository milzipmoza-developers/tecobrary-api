package dev.milzipmoza.tecobrary.core.domain.book.subdomain.review.entity;

public enum ReviewAmount {

    ALL("전부 읽었어요"),
    CHAPTERS("여러 챕터 읽었어요"),
    ONE_CHAPTER("한 챕터 읽었어요"),
    LITTLE("조금 읽어봤어요"),
    ABSTRACT("서론만 읽었어요");

    private final String displayName;

    ReviewAmount(String displayName) {
        this.displayName = displayName;
    }
}
