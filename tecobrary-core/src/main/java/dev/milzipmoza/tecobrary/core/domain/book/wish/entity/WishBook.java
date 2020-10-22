package dev.milzipmoza.tecobrary.core.domain.book.wish.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.book.Book;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class WishBook extends BaseTimeEntity {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "title", column = @Column(name = "title", nullable = false)),
            @AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false, unique = true)),
            @AttributeOverride(name = "author", column = @Column(name = "author", nullable = false)),
            @AttributeOverride(name = "publisher", column = @Column(name = "publisher", nullable = false)),
            @AttributeOverride(name = "description", column = @Column(name = "description", nullable = false))
    })
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "wish_member_id")
    private Member wishMember;

    @Builder
    public WishBook(Book book, Member wishMember) {
        this.book = book;
        this.wishMember = wishMember;
    }
}
