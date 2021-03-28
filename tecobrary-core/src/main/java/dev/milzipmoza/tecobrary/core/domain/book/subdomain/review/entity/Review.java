package dev.milzipmoza.tecobrary.core.domain.book.subdomain.review.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseTimeEntity {

    @Column(nullable = false)
    private String memberNumber;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewScore score;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewAmount amount;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewStatus status;

    @Column
    private String amountDetail;

    @Column
    private boolean edited;

    @Column
    private LocalDateTime reviewDateTime;

    @Column
    private LocalDateTime lastEditDateTime;

    @Column
    private LocalDateTime deleteDateTime;

    @Builder
    private Review(String memberNumber,
                   String content,
                   ReviewScore score,
                   ReviewAmount amount,
                   String amountDetail,
                   boolean edited,
                   ReviewStatus status,
                   LocalDateTime reviewDateTime) {
        this.memberNumber = memberNumber;
        this.content = content;
        this.score = score;
        this.amount = amount;
        this.amountDetail = amountDetail;
        this.edited = edited;
        this.status = status;
        this.reviewDateTime = reviewDateTime;
    }

    public static Review writeReview(String memberNumber,
                                     String content,
                                     ReviewScore score,
                                     ReviewAmount amount,
                                     String amountDetail,
                                     LocalDateTime reviewDateTime) {
        return Review.builder()
                .memberNumber(memberNumber)
                .content(content)
                .score(score)
                .status(ReviewStatus.PUBLIC)
                .amount(amount)
                .amountDetail(amountDetail)
                .reviewDateTime(reviewDateTime)
                .build();
    }

    public Review editReview(String content,
                             ReviewScore score,
                             ReviewAmount amount,
                             String amountDetail,
                             LocalDateTime lastEditDateTime) {
        this.content = content;
        this.score = score;
        this.amount = amount;
        this.amountDetail = amountDetail;
        this.edited = true;
        this.lastEditDateTime = lastEditDateTime;
        return this;
    }

    public Review deleteReview(LocalDateTime deleteDateTime) {
        this.status = ReviewStatus.DELETED;
        this.deleteDateTime = deleteDateTime;
        return this;
    }
}
