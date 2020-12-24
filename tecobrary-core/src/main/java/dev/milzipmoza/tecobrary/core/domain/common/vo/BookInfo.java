package dev.milzipmoza.tecobrary.core.domain.common.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class BookInfo {

    private String title;
    private String isbn;
    private String author;
    private String imageUrl;
    private String publisher;
    private String description;

    @Builder
    public BookInfo(String title, String isbn, String author, String imageUrl, String publisher, String description) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.imageUrl = imageUrl;
        this.publisher = publisher;
        this.description = description;
    }

    public void updateTitle(String title) {
        if (StringUtils.hasLength(title)) {
            this.title = title;
        }
    }

    public void updateAuthor(String author) {
        if (StringUtils.hasLength(author)) {
            this.author = author;
        }
    }

    public void updatePublisher(String publisher) {
        if (StringUtils.hasLength(publisher)) {
            this.publisher = publisher;
        }
    }

    public void updateDescription(String description) {
        if (StringUtils.hasLength(description)) {
            this.description = description;
        }
    }

    public void updateImageUrl(String imageUrl) {
        if (StringUtils.hasLength(imageUrl)) {
            this.imageUrl = imageUrl;
        }
    }
}
