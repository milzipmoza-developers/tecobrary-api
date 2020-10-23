package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthService;
import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RentRepositoryTest {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private EntityManager em;

    @Test
    void save() {
        Rent rent = Rent.builder()
                .rentDateTime(LocalDateTime.now())
                .rentBook(new Book("1", new LibraryBook(BookInfo.builder()
                        .title("제목")
                        .isbn("1234")
                        .author("루피")
                        .publication("밀짚모자 출판사")
                        .description("이것은 책이다.")
                        .build())))
                .rentMember(Member.builder()
                        .authService(new MemberAuthService("auth-key", MemberAuthProvider.GITHUB))
                        .build())
                .build();

        Rent savedRent = rentRepository.saveAndFlush(rent);

        Long id = savedRent.getId();

        em.clear();

        Rent foundRent = rentRepository.findById(id).get();

        assertThat(foundRent.getId()).isEqualTo(id);
    }
}