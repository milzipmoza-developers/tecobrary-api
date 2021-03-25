package dev.milzipmoza.tecobrary.core.domain.book.dto;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookDto {

    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;

    @Builder
    public BookDto(Long id, String title, String imageUrl, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static BookDto of(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getBookInfo().getTitle())
                .imageUrl(book.getBookInfo().getImageUrl())
                .author(book.getBookInfo().getAuthor())
                .publisher(book.getBookInfo().getPublisher())
                .description(book.getBookInfo().getDescription())
                .isbn(book.getBookInfo().getIsbn())
                .build();
    }
}
