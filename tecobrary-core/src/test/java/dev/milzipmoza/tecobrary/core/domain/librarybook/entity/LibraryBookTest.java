package dev.milzipmoza.tecobrary.core.domain.librarybook.entity;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryBookTest {

    private static final String UPDATE_TITLE = "제목";
    private static final String UPDATE_AUTHOR = "요리왕 상디";
    private static final String UPDATE_IMAGE_URL = "imageUrl";
    private static final String UPDATE_PUBLISHER = "발라티에 출판사";
    private static final String UPDATE_DESCRIPTION = "내 요리는 레이디들을 위한 요리~";

    @Test
    @DisplayName("도서 정보를 수정할 수 있다.")
    void updateBookInfo() {
        LibraryBook libraryBook = new LibraryBook(BookInfo.builder()
                .title("제목")
                .isbn("isbn")
                .author("개발왕루피")
                .publisher("밀짚모자출판사")
                .description("이것은 책의 간단한 설명을 담는 곳이여")
                .build());

        libraryBook.updateBookInfo(UPDATE_TITLE, UPDATE_AUTHOR, UPDATE_IMAGE_URL, UPDATE_PUBLISHER, UPDATE_DESCRIPTION);

        BookInfo bookInfo = libraryBook.getBookInfo();

        assertThat(bookInfo.getTitle()).isEqualTo(UPDATE_TITLE);
        assertThat(bookInfo.getAuthor()).isEqualTo(UPDATE_AUTHOR);
        assertThat(bookInfo.getImageUrl()).isEqualTo(UPDATE_IMAGE_URL);
        assertThat(bookInfo.getPublisher()).isEqualTo(UPDATE_PUBLISHER);
        assertThat(bookInfo.getDescription()).isEqualTo(UPDATE_DESCRIPTION);
    }

    @Test
    @DisplayName("장서를 제거할 수 있다.")
    void removeBook() {
        LibraryBook libraryBook = new LibraryBook(BookInfo.builder()
                .title("제목")
                .isbn("isbn")
                .author("개발왕루피")
                .publisher("밀짚모자출판사")
                .description("이것은 책의 간단한 설명을 담는 곳이여")
                .build());

        libraryBook.addBook("1");
        libraryBook.addBook("2");

        libraryBook.deleteBook("2");

        assertThat(libraryBook.getBooks().size()).isEqualTo(1);
    }
}