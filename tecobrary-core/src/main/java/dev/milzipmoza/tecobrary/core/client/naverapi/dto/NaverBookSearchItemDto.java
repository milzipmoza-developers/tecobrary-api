package dev.milzipmoza.tecobrary.core.client.naverapi.dto;

import lombok.Getter;

@Getter
public class NaverBookSearchItemDto {

    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    public NaverBookSearchItemDto() {
    }

    public NaverBookSearchItemDto(String title, String image, String author, String publisher, String isbn, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }
}
