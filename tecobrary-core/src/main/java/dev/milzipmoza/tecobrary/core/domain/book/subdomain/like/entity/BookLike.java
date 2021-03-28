package dev.milzipmoza.tecobrary.core.domain.book.subdomain.like.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Where(clause = "isUnlike=false")
public class BookLike extends BaseTimeEntity {

    @Column(nullable = false)
    private String memberNumber;

    @Column
    private LocalDateTime likeDateTime;

    @Column
    private LocalDateTime unlikeDateTime;

    @Column
    private boolean isUnlike;

    public BookLike(String memberNumber, LocalDateTime likeDateTime) {
        this.memberNumber = memberNumber;
        this.likeDateTime = likeDateTime;
        this.isUnlike = false;
    }

    public boolean doUnlike(LocalDateTime unlikeDateTime) {
        this.unlikeDateTime = unlikeDateTime;
        return this.isUnlike = true;
    }
}
