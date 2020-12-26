package dev.milzipmoza.tecobrary.api.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    public LibraryBookDetailResponse(Long id, String title, String image, String author, String publisher, String isbn, String description, List<BookDto> books) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
        this.books = books;
    }

    public static LibraryBookDetailResponse of(LibraryBookDetailDto libraryBooks) {
        return LibraryBookDetailResponse.builder()
                .id(libraryBooks.getId())
                .title(libraryBooks.getTitle())
                .image(libraryBooks.getImageUrl())
                .author(libraryBooks.getAuthor())
                .publisher(libraryBooks.getPublisher())
                .isbn(libraryBooks.getIsbn())
                .description(libraryBooks.getDescription())
                .books(libraryBooks.getBooks())
                .build();
    }
}
