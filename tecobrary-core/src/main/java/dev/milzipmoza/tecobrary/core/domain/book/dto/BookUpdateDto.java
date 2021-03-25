package dev.milzipmoza.tecobrary.core.domain.book.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookUpdateDto {

    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;

    @Builder
    public BookUpdateDto(Long id, String title, String imageUrl, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }
}
