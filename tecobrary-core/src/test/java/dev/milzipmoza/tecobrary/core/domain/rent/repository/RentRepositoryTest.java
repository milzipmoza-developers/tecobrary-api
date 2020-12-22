package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.book.repository.BookRepository;
import dev.milzipmoza.tecobrary.core.domain.books.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.member.entity.Member;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthProvider;
import dev.milzipmoza.tecobrary.core.domain.member.entity.MemberAuthService;
import dev.milzipmoza.tecobrary.core.domain.member.repository.MemberRepository;
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
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private EntityManager em;

    @Test
    void save() {
        Book savedBook = bookRepository.save(new Book("1", new LibraryBook(BookInfo.builder()
                .title("제목")
                .isbn("12345")
                .author("루피")
                .publisher("밀짚모자 출판사")
                .description("이것은 책이다.")
                .build())));

        Member savedMember = memberRepository.save(Member.builder()
                .authService(new MemberAuthService("auth-key", MemberAuthProvider.GITHUB))
                .build());

        Rent rent = Rent.builder()
                .rentDateTime(LocalDateTime.now())
                .rentBook(savedBook)
                .rentMember(savedMember)
                .build();

        Rent savedRent = rentRepository.saveAndFlush(rent);

        Long id = savedRent.getId();

        em.clear();

        Rent foundRent = rentRepository.findById(id).get();

        assertThat(foundRent.getId()).isEqualTo(id);
    }
}