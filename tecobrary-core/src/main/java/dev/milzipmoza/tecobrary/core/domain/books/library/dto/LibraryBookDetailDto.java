package dev.milzipmoza.tecobrary.core.domain.books.library.dto;

import dev.milzipmoza.tecobrary.core.domain.books.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class LibraryBookDetailDto {

    private final Long id;
    private final String title;
    private final String imageUrl;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final String description;
    private final List<BookDto> books;

    @Builder
    public LibraryBookDetailDto(Long id, String title, String imageUrl, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.books = Collections.emptyList();
    }

    public static LibraryBookDetailDto of(LibraryBook libraryBook) {
        return LibraryBookDetailDto.builder()
                .id(libraryBook.getId())
                .title(libraryBook.getBookInfo().getTitle())
                .imageUrl(libraryBook.getBookInfo().getImageUrl())
                .author(libraryBook.getBookInfo().getAuthor())
                .publisher(libraryBook.getBookInfo().getPublisher())
                .isbn(libraryBook.getBookInfo().getIsbn())
                .description(libraryBook.getBookInfo().getDescription())
                .build();
    }
}
