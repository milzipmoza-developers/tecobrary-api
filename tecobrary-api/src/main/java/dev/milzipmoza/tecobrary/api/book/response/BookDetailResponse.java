package dev.milzipmoza.tecobrary.api.book.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookDetailResponse {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    @Builder
    public BookDetailResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static BookDetailResponse of(BookDetailDto libraryBooks) {
        return BookDetailResponse.builder()
                .id(libraryBooks.getId())
                .title(libraryBooks.getTitle())
                .image(libraryBooks.getImageUrl())
                .author(libraryBooks.getAuthor())
                .publisher(libraryBooks.getPublisher())
                .isbn(libraryBooks.getIsbn())
                .description(libraryBooks.getDescription())
                .build();
    }
}
