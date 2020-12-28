package dev.milzipmoza.tecobrary.core.domain.wishbook.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class WishBookStatusHistory extends BaseTimeEntity {

    @Column(nullable = false)
    private LocalDateTime changeDateTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WishBookStatus wishBookStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private WishBook wishBook;

    @Builder
    public WishBookStatusHistory(LocalDateTime changeDateTime, WishBookStatus wishBookStatus, WishBook wishBook) {
        this.changeDateTime = changeDateTime;
        this.wishBookStatus = wishBookStatus;
        this.wishBook = wishBook;
    }
}
