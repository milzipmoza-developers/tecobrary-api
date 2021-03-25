package dev.milzipmoza.tecobrary.core.domain.book.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
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
    void saveTest() {
        Book book = new Book(BookInfo.builder()
                .title("제목")
                .author("작가")
                .imageUrl("이미지")
                .publisher("출판사")
                .isbn("isbn")
                .description("요약")
                .build());

        Book savedBook = bookRepository.saveAndFlush(book);

        Long id = savedBook.getId();

        em.clear();

        Book foundBook = bookRepository.findById(id).get();

        assertThat(foundBook.getId()).isEqualTo(id);
        assertThat(foundBook.getCreatedAt()).isNotNull();
        assertThat(foundBook.getModifiedAt()).isNotNull();
    }
}