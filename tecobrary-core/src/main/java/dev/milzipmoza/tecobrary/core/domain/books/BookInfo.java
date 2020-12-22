package dev.milzipmoza.tecobrary.core.domain.books;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BookInfo {

    private String title;
    private String isbn;
    private String author;
    private String imageUrl;
    private String publisher;
    private String description;

    @Builder
    public BookInfo(String title, String isbn, String author, String imageUrl, String publisher, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.description = description;
    }

    public void updateAuthor(String author) {
        this.author = author;
    }

    public void updatePublisher(String publisher) {
        this.publisher = publisher;
    }

    public void updateDescription(String description) {
        this.description = description;
    }
}
