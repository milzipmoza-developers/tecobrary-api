package dev.milzipmoza.tecobrary.api.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LibraryBookUpdateResponse {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    @Builder
    public LibraryBookUpdateResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static LibraryBookUpdateResponse of(LibraryBookDto libraryBookDto) {
        return LibraryBookUpdateResponse.builder()
                .id(libraryBookDto.getId())
                .title(libraryBookDto.getTitle())
                .author(libraryBookDto.getAuthor())
                .publisher(libraryBookDto.getPublisher())
                .description(libraryBookDto.getDescription())
                .isbn(libraryBookDto.getIsbn())
                .image(libraryBookDto.getImageUrl())
                .build();
    }
}
