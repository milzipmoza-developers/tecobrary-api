package dev.milzipmoza.tecobrary.core.domain.books.library.dto;

import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LibraryBookDto {

    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;

    @Builder
    public LibraryBookDto(Long id, String title, String imageUrl, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static LibraryBookDto of(LibraryBook libraryBook) {
        return LibraryBookDto.builder()
                .id(libraryBook.getId())
                .title(libraryBook.getBookInfo().getTitle())
                .imageUrl(libraryBook.getBookInfo().getImageUrl())
                .author(libraryBook.getBookInfo().getAuthor())
                .publisher(libraryBook.getBookInfo().getPublisher())
                .description(libraryBook.getBookInfo().getDescription())
                .isbn(libraryBook.getBookInfo().getIsbn())
                .build();
    }
}
