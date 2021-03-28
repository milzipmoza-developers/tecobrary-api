package dev.milzipmoza.tecobrary.api.book.response;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookUpdateResponse {

    private Long id;
    private String title;
    private String image;
    private String author;
    private String publisher;
    private String isbn;
    private String description;

    @Builder
    public BookUpdateResponse(Long id, String title, String image, String author, String publisher, String isbn, String description) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.description = description;
    }

    public static BookUpdateResponse of(BookDto bookDto) {
        return BookUpdateResponse.builder()
                .id(bookDto.getId())
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publisher(bookDto.getPublisher())
                .description(bookDto.getDescription())
                .isbn(bookDto.getIsbn())
                .image(bookDto.getImageUrl())
                .build();
    }
}
