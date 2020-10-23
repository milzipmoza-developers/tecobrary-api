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
    private String publication;
    private String description;

    @Builder
    private BookInfo(String title, String isbn, String author, String publication, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publication = publication;
        this.description = description;
    }

    public void updateAuthor(String author) {
        this.author = author;
    }

    public void updatePublication(String publication) {
        this.publication = publication;
    }

    public void updateDescription(String description) {
        this.description = description;
    }
}
