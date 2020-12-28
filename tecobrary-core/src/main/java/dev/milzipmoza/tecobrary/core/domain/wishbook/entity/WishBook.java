package dev.milzipmoza.tecobrary.core.domain.wishbook.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.wishbook.exception.WishBookException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class WishBook extends BaseTimeEntity {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "title", column = @Column(name = "title", nullable = false)),
            @AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false, unique = true)),
            @AttributeOverride(name = "author", column = @Column(name = "author", nullable = false)),
            @AttributeOverride(name = "imageUrl", column = @Column(name = "image_url", nullable = false)),
            @AttributeOverride(name = "publisher", column = @Column(name = "publisher", nullable = false)),
            @AttributeOverride(name = "description", column = @Column(name = "description", nullable = false))
    })
    private BookInfo bookInfo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "wishBook")
    private final List<WishBookStatusHistory> wishBookStatusHistories = new ArrayList<>();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WishBookStatus wishBookStatus;

    @Column(nullable = false)
    private String wishMemberNumber;

    @Column(nullable = false)
    private LocalDateTime requestDateTime;

    @Column
    private LocalDateTime completedDateTime;

    @Builder
    public WishBook(BookInfo bookInfo, String wishMemberNumber) {
        this.bookInfo = bookInfo;
        this.wishBookStatus = WishBookStatus.REQUESTED;
        this.wishMemberNumber = wishMemberNumber;

        LocalDateTime now = LocalDateTime.now();
        this.requestDateTime = now;

        saveHistory("멤버 희망도서 등록", now);
    }

    public void updateStatus(WishBookStatus updatedStatus, String reason) {
        updateStatus(updatedStatus, reason, LocalDateTime.now());
    }

    public void complete(String reason) {
        LocalDateTime now = LocalDateTime.now();
        updateStatus(WishBookStatus.COMPLETED, reason, now);
        this.completedDateTime = now;
    }

    private void updateStatus(WishBookStatus updatedStatus, String reason, LocalDateTime now) {
        if (!this.wishBookStatus.changeableTo(updatedStatus)) {
            throw new WishBookException("상태 변경이 불가능합니다.");
        }
        this.wishBookStatus = updatedStatus;

        saveHistory(reason, now);
    }

    private void saveHistory(String reason, LocalDateTime dateTime) {
        this.wishBookStatusHistories.add(WishBookStatusHistory.builder()
                .reason(reason)
                .changeDateTime(dateTime)
                .wishBookStatus(this.wishBookStatus)
                .wishBook(this)
                .build());
    }
}
