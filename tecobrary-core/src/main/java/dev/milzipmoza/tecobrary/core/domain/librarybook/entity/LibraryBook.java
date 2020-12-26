package dev.milzipmoza.tecobrary.core.domain.librarybook.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookSerialNotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LibraryBook extends BaseTimeEntity {

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "libraryBook", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public LibraryBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void updateBookInfo(String title, String author, String imageUrl, String publisher, String description) {
        this.bookInfo.updateTitle(title);
        this.bookInfo.updateAuthor(author);
        this.bookInfo.updateImageUrl(imageUrl);
        this.bookInfo.updatePublisher(publisher);
        this.bookInfo.updateDescription(description);
    }

    public void addBook(String bookSerial) {
        this.books.add(new Book(bookSerial, this));
    }

    public void deleteBook(String bookSerial) {
        Book deleteBook = this.books.stream()
                .filter(book -> book.getBookSerial().equals(bookSerial))
                .findAny()
                .orElseThrow(() -> new BookSerialNotFoundException("해당하는 장서가 존재하지 않습니다."));
        books.remove(deleteBook);
        deleteBook.delete();
    }
}

