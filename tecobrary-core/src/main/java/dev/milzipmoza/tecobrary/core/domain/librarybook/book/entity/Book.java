package dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity;


import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookAlreadyRentException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseTimeEntity {

    @Column(nullable = false, unique = true)
    private String bookSerial;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_book_id")
    private LibraryBook libraryBook;

    public Book(String bookSerial, LibraryBook libraryBook) {
        this.bookSerial = bookSerial;
        this.bookStatus = BookStatus.IN_LIBRARY;
        this.libraryBook = libraryBook;
    }

    public void delete() {
        this.libraryBook = null;
    }

    public void rent() {
        if (this.bookStatus.equals(BookStatus.RENT)) {
            throw new BookAlreadyRentException("이미 대여중인 장서입니다.");
        }
        this.bookStatus = BookStatus.RENT;
    }
}
