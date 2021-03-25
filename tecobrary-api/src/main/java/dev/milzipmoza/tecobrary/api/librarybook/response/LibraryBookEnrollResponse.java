package dev.milzipmoza.tecobrary.api.librarybook.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryBookEnrollResponse {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    @Builder
    public LibraryBookEnrollResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static LibraryBookEnrollResponse of(BookDto enrolledBook) {
        return LibraryBookEnrollResponse.builder()
                .id(enrolledBook.getId())
                .title(enrolledBook.getTitle())
                .author(enrolledBook.getAuthor())
                .publisher(enrolledBook.getPublisher())
                .description(enrolledBook.getDescription())
                .isbn(enrolledBook.getIsbn())
                .image(enrolledBook.getImageUrl())
                .build();
    }
}
