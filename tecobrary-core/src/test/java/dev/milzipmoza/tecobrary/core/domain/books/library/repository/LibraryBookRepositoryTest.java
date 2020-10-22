package dev.milzipmoza.tecobrary.core.domain.books.library.repository;

import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LibraryBookRepositoryTest {

    @Autowired
    private LibraryBookRepository libraryBookRepository;

    @Autowired
    private EntityManager em;

    @Test
    void saveTest() {
        LibraryBook libraryBook = new LibraryBook(BookInfo.builder()
                .title("제목")
                .author("작가")
                .publication("출판사")
                .isbn("isbn")
                .description("요약")
                .build());

        LibraryBook savedLibraryBook = libraryBookRepository.saveAndFlush(libraryBook);

        Long id = savedLibraryBook.getId();

        em.clear();

        LibraryBook foundLibraryBook = libraryBookRepository.findById(id).get();

        assertThat(foundLibraryBook.getId()).isEqualTo(id);
        assertThat(foundLibraryBook.getCreatedAt()).isNotNull();
        assertThat(foundLibraryBook.getModifiedAt()).isNotNull();
    }
}