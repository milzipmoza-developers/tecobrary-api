package dev.milzipmoza.tecobrary.core.domain.books.library.entity;

import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryBookTest {

    private static final String UPDATE_AUTHOR = "요리왕 상디";
    private static final String UPDATE_PUBLICATION = "발라티에 출판사";
    private static final String UPDATE_DESCRIPTION = "내 요리는 레이디들을 위한 요리~";

    @Test
    @DisplayName("도서 정보를 수정할 수 있다.")
    void updateBookInfo() {
        LibraryBook libraryBook = new LibraryBook(BookInfo.builder()
                .title("제목")
                .isbn("isbn")
                .author("개발왕루피")
                .publication("밀짚모자출판사")
                .description("이것은 책의 간단한 설명을 담는 곳이여")
                .build());

        libraryBook.updateBookInfo(UPDATE_AUTHOR, UPDATE_PUBLICATION, UPDATE_DESCRIPTION);

        BookInfo bookInfo = libraryBook.getBookInfo();

        assertThat(bookInfo.getAuthor()).isEqualTo(UPDATE_AUTHOR);
        assertThat(bookInfo.getPublication()).isEqualTo(UPDATE_PUBLICATION);
        assertThat(bookInfo.getDescription()).isEqualTo(UPDATE_DESCRIPTION);
    }
}