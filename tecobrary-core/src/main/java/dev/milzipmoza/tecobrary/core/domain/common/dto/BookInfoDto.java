package dev.milzipmoza.tecobrary.core.domain.common.dto;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookInfoDto {

    private final String title;
    private final String isbn;
    private final String author;
    private final String imageUrl;
    private final String publisher;
    private final String description;

    @Builder
    public BookInfoDto(String title, String isbn, String author, String imageUrl, String publisher, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.description = description;
    }

    public static BookInfoDto of(BookInfo bookInfo) {
        return BookInfoDto.builder()
                .title(bookInfo.getTitle())
                .isbn(bookInfo.getIsbn())
                .author(bookInfo.getAuthor())
                .imageUrl(bookInfo.getImageUrl())
                .publisher(bookInfo.getPublisher())
                .description(bookInfo.getDescription())
                .build();
    }
}
