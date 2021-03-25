package dev.milzipmoza.tecobrary.api.librarybook.response;

import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDetailDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    public LibraryBookDetailResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
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
                .build();
    }
}
