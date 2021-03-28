package dev.milzipmoza.tecobrary.core.domain.book.subdomain.review.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ReviewTest {

    @DisplayName("새로운 리뷰를 작성한다.")
    @Test
    void writeNewReview() {
        Review review = Review.writeReview("1234", "참 좋은 책이예요.", ReviewScore.FIVE, ReviewAmount.ALL, "", LocalDateTime.now());

        assertThat(review.isEdited()).isFalse();
        assertThat(review.getReviewDateTime()).isNotNull();
        assertThat(review.getLastEditDateTime()).isNull();
        assertThat(review.getDeleteDateTime()).isNull();
    }

    @DisplayName("리뷰를 수정한다.")
    @Test
    void editReview() {
        LocalDateTime now = LocalDateTime.now();
        Review review = Review.writeReview("1234", "참 좋은 책이예요.", ReviewScore.FIVE, ReviewAmount.ALL, "", now);

        review.editReview("좋진 않네요", ReviewScore.FOUR, ReviewAmount.ALL, "", now.plusMinutes(30));

        assertThat(review.isEdited()).isTrue();
        assertThat(review.getReviewDateTime()).isNotNull();
        assertThat(review.getLastEditDateTime()).isNotNull();
        assertThat(review.getDeleteDateTime()).isNull();
    }

    @DisplayName("리뷰를 제거한다.")
    @Test
    void deleteReview() {
        LocalDateTime now = LocalDateTime.now();
        Review review = Review.writeReview("1234", "참 좋은 책이예요.", ReviewScore.FIVE, ReviewAmount.ALL, "", now);

        review.deleteReview(now.plusDays(1));

        assertThat(review.getReviewDateTime()).isNotNull();
        assertThat(review.getLastEditDateTime()).isNull();
        assertThat(review.getDeleteDateTime()).isNotNull();
    }
}