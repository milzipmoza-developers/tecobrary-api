package dev.milzipmoza.tecobrary.core.domain.wishbook.service;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import dev.milzipmoza.tecobrary.core.domain.wishbook.repository.WishBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WishBookCommandService {

    private final WishBookRepository wishBookRepository;

    @Transactional
    public WishBookDto enroll(String memberNumber, WishBookEnrollDto enrollDto) {
        WishBook wishBook = WishBook.builder()
                .bookInfo(BookInfo.of(enrollDto))
                .wishMemberNumber(memberNumber)
                .build();
        WishBook savedWishBook = wishBookRepository.save(wishBook);
        return WishBookDto.of(savedWishBook);
    }
}
