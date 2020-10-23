package dev.milzipmoza.tecobrary.core.domain.rent.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
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
public class Rent extends BaseTimeEntity {

    @Column(nullable = false)
    private boolean returned;

    @Column(nullable = false)
    private LocalDateTime rentDateTime;

    @Column
    private LocalDateTime returnDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_book_id")
    private Book rentBook;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rent_member_id")
    private Member rentMember;

    @OneToMany(mappedBy = "rent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RentHistory> rentHistories = new ArrayList<>();

    @Builder
    private Rent(LocalDateTime rentDateTime, Book rentBook, Member rentMember) {
        this.returned = false;
        this.rentDateTime = rentDateTime;
        this.rentBook = rentBook;
        this.rentMember = rentMember;

        saveHistory();
    }

    private void saveHistory() {
        RentHistory rentHistory = RentHistory.builder()
                .returned(this.returned)
                .rentDateTime(this.rentDateTime)
                .rentBookId(this.rentBook.getId())
                .rentMemberId(this.rentMember.getId())
                .txDateTime(LocalDateTime.now())
                .rent(this)
                .build();

        this.rentHistories.add(rentHistory);
    }
}
