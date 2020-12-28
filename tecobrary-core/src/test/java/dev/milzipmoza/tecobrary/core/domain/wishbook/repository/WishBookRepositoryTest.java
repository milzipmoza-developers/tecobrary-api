package dev.milzipmoza.tecobrary.core.domain.wishbook.repository;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WishBookRepositoryTest {

    @Autowired
    private WishBookRepository wishBookRepository;

    @Autowired
    private EntityManager em;

    @Test
    void wishBookSave() {
        WishBook wishBook = WishBook.builder()
                .bookInfo(BookInfo.builder()
                        .title("제목")
                        .author("작가")
                        .imageUrl("이미지")
                        .publisher("출판사")
                        .isbn("isbn")
                        .description("요약")
                        .build())
                .wishMemberNumber("member_number")
                .build();

        WishBook savedWishBook = wishBookRepository.saveAndFlush(wishBook);

        Long id = savedWishBook.getId();

        em.clear();

        WishBook foundWishBook = wishBookRepository.findById(id).get();

        assertThat(foundWishBook.getId()).isEqualTo(id);
        assertThat(foundWishBook.getCreatedAt()).isNotNull();
        assertThat(foundWishBook.getModifiedAt()).isNotNull();
    }
}