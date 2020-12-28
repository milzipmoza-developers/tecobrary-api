package dev.milzipmoza.tecobrary.core.domain.wishbook.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WishBookEnrollDto {

    private final String title;
    private final String image;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;

    @Builder
    public WishBookEnrollDto(String title, String image, String author, String publisher, String isbn, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }
}
