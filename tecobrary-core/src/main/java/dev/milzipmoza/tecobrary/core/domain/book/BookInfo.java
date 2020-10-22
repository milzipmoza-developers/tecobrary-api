package dev.milzipmoza.tecobrary.core.domain.book;

import lombok.*;

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
}
