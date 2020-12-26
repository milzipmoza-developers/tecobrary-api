package dev.milzipmoza.tecobrary.api.librarybook.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryBookUpdateRequest {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String description;

    public LibraryBookUpdateRequest(Long id, String title, String image, String author, String publisher, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.description = description;
    }
}
