package dev.milzipmoza.tecobrary.core.domain.rent.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Where(clause = "isReturned = 'true'")
public class Rent extends BaseTimeEntity {

    @Column(nullable = false)
    private boolean isReturned;

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

    @Builder
    private Rent(LocalDateTime rentDateTime, Book rentBook, Member rentMember) {
        this.isReturned = false;
        this.rentDateTime = rentDateTime;
        this.rentBook = rentBook;
        this.rentMember = rentMember;
    }
}
