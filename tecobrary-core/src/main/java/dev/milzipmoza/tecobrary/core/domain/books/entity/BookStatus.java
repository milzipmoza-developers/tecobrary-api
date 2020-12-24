package dev.milzipmoza.tecobrary.core.domain.books.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookStatus {
    IN_LIBRARY("비치중"),
    RENT("대여중");

    private final String displayName;
}
