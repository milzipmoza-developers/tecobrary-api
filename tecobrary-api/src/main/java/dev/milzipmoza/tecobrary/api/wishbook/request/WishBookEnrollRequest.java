package dev.milzipmoza.tecobrary.api.wishbook.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WishBookEnrollRequest {

    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    @Builder
    public WishBookEnrollRequest(String title, String image, String author, String publisher, String isbn, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }
}
