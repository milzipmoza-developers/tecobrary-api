package dev.milzipmoza.tecobrary.core.domain.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class LibraryBookElementDto {

    private final Long id;
    private final String title;
    private final String author;
    private final String publisher;
    private final String isbn;
    private final List<String> categories = Collections.emptyList();

    @Builder
    public LibraryBookElementDto(Long id, String title, String author, String publisher, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public static LibraryBookElementDto of(LibraryBook libraryBook) {
        return LibraryBookElementDto.builder()
                .id(libraryBook.getId())
                .title(libraryBook.getBookInfo().getTitle())
                .author(libraryBook.getBookInfo().getAuthor())
                .publisher(libraryBook.getBookInfo().getPublisher())
                .isbn(libraryBook.getBookInfo().getIsbn())
                .build();
    }
}
