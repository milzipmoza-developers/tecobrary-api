package dev.milzipmoza.tecobrary.core.domain.books.library.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.books.entity.Book;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "libraryBook")
    private List<Book> books = new ArrayList<>();

    public LibraryBook(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void updateBookInfo(String author, String publisher, String description) {
        this.bookInfo.updateAuthor(author);
        this.bookInfo.updatePublisher(publisher);
        this.bookInfo.updateDescription(description);
    }
}

