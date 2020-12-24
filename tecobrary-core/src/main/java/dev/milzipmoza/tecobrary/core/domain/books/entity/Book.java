package dev.milzipmoza.tecobrary.core.domain.books.entity;


import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseTimeEntity {

    @Column(nullable = false)
    private String bookSerial;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "library_book_id")
    private LibraryBook libraryBook;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BookStatusHistory> bookStatusHistories = new ArrayList<>();

    public Book(String bookSerial, LibraryBook libraryBook) {
        this.bookSerial = bookSerial;
        this.bookStatus = BookStatus.IN_LIBRARY;
        this.libraryBook = libraryBook;

        saveHistory();
    }

    private void saveHistory() {
        BookStatusHistory bookStatusHistory = new BookStatusHistory(this.bookStatus, this);
        this.bookStatusHistories.add(bookStatusHistory);
    }
}
