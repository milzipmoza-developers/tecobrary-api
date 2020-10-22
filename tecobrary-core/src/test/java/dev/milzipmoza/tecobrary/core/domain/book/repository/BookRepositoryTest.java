package dev.milzipmoza.tecobrary.core.domain.book.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private EntityManager em;

    @Test
    void saveBook() {
        Book book = new Book("1", new LibraryBook(BookInfo.builder()
                .title("제목")
                .isbn("1234")
                .author("루피")
                .publication("밀짚모자 출판사")
                .description("이것은 책이다.")
                .build()));

        Book savedBook = bookRepository.saveAndFlush(book);

        Long id = savedBook.getId();

        em.clear();

        Book foundBook = bookRepository.findById(id).get();

        assertThat(foundBook.getId()).isEqualTo(id);
        assertThat(foundBook.getCreatedAt()).isNotNull();
        assertThat(foundBook.getCreatedBy()).isNotNull();
        assertThat(foundBook.getModifiedAt()).isNotNull();
        assertThat(foundBook.getModifiedBy()).isNotNull();
    }
}