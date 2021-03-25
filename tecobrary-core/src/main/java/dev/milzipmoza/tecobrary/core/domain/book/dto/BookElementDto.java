package dev.milzipmoza.tecobrary.core.domain.book.dto;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookElementDto {

    private final Long id;
    private final String title;
    private final String author;
    private final String publisher;
    private final String isbn;

    @Builder
    public BookElementDto(Long id, String title, String author, String publisher, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public static BookElementDto of(Book book) {
        return BookElementDto.builder()
                .id(book.getId())
                .title(book.getBookInfo().getTitle())
                .author(book.getBookInfo().getAuthor())
                .publisher(book.getBookInfo().getPublisher())
                .isbn(book.getBookInfo().getIsbn())
                .build();
    }
}
