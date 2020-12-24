package dev.milzipmoza.tecobrary.core.domain.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LibraryBookEnrollDto {

    private final String title;
    private final String image;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;

    @Builder
    public LibraryBookEnrollDto(String title, String image, String author, String publisher, String isbn, String description) {
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public LibraryBook toEntity() {
        return new LibraryBook(BookInfo.builder()
                .title(this.title)
                .imageUrl(this.image)
                .author(this.author)
                .publisher(this.publisher)
                .isbn(this.isbn)
                .description(this.description)
                .build());
    }
}
