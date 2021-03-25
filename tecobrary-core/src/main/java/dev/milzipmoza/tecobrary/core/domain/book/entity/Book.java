package dev.milzipmoza.tecobrary.core.domain.book.entity;

import dev.milzipmoza.tecobrary.core.domain.audit.BaseTimeEntity;
import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book extends BaseTimeEntity {

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "title", column = @Column(name = "title", nullable = false)),
            @AttributeOverride(name = "isbn", column = @Column(name = "isbn", nullable = false, unique = true)),
            @AttributeOverride(name = "author", column = @Column(name = "author", nullable = false)),
            @AttributeOverride(name = "imageUrl", column = @Column(name = "image_url", nullable = false)),
            @AttributeOverride(name = "publisher", column = @Column(name = "publisher", nullable = false)),
            @AttributeOverride(name = "description", column = @Column(name = "description", nullable = false))
    })
    private BookInfo bookInfo;

    public Book(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void updateBookInfo(String title, String author, String imageUrl, String publisher, String description) {
        this.bookInfo.updateTitle(title);
        this.bookInfo.updateAuthor(author);
        this.bookInfo.updateImageUrl(imageUrl);
        this.bookInfo.updatePublisher(publisher);
        this.bookInfo.updateDescription(description);
    }
}

