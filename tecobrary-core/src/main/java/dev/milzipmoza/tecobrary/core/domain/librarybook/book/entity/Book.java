package dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity;


import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookAlreadyRentException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookRentMemberIdentifyFailedException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseTimeEntity {

    @Column(nullable = false, unique = true)
    private String bookSerial;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @Column
    private String rentMemberNumber;

    @Column
    private LocalDateTime rentDateTime;

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

    public void rent(String rentMemberNumber) {
        if (this.bookStatus.equals(BookStatus.RENT)) {
            throw new BookAlreadyRentException("이미 대여중인 장서입니다.");
        }
        this.bookStatus = BookStatus.RENT;
        this.rentMemberNumber = rentMemberNumber;
        this.rentDateTime = LocalDateTime.now();
    }

    public void doReturn(String rentMemberNumber) {
        if (this.bookStatus.equals(BookStatus.IN_LIBRARY)) {
            throw new BookAlreadyRentException("이미 비치중인 장서입니다.");
        }
        if (!this.rentMemberNumber.equals(rentMemberNumber)) {
            throw new BookRentMemberIdentifyFailedException("대여 내역을 확인해주세요.");
        }
        this.bookStatus = BookStatus.IN_LIBRARY;
        initRentMemberNumber();
        initRentDateTime();
    }

    private void initRentDateTime() {
        this.rentDateTime = null;
    }

    private void initRentMemberNumber() {
        this.rentMemberNumber = null;
    }
}
