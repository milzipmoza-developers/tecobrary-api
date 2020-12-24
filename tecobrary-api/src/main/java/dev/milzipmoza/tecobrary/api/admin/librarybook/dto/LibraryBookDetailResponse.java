package dev.milzipmoza.tecobrary.api.admin.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.books.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
public class LibraryBookDetailResponse {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;
    private List<BookDto> books;

    @Builder
    public LibraryBookDetailResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.books = Collections.emptyList();
    }

    public static LibraryBookDetailResponse of(LibraryBookDetailDto book) {
        return LibraryBookDetailResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .image(book.getImageUrl())
                .author(book.getAuthor())
                .publisher(book.getPublisher())
                .isbn(book.getIsbn())
                .description(book.getDescription())
                .build();
    }
}
