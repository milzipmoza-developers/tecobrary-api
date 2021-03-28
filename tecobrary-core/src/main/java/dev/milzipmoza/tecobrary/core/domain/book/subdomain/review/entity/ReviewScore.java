package dev.milzipmoza.tecobrary.core.domain.book.subdomain.review.entity;

public enum ReviewScore {

    ONE("최악이예요"),
    TWO("그럭저럭이예요"),
    THREE("한번쯤 읽을만 해요"),
    FOUR("좋은 책이예요"),
    FIVE("최고예요");

    private final String displayScore;

    ReviewScore(String displayScore) {
        this.displayScore = displayScore;
    }
}
