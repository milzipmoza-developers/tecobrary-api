package dev.milzipmoza.tecobrary.core.domain.wishbook.service;

import dev.milzipmoza.tecobrary.core.domain.common.vo.BookInfo;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import dev.milzipmoza.tecobrary.core.domain.wishbook.exception.WishBookException;
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

    @Transactional
    public WishBookDto confirmWishBook(Long id, String reason) {
        WishBook wishBook = wishBookRepository.findById(id)
                .orElseThrow(() -> new WishBookException("해당하는 희망도서를 찾을 수 없습니다."));
        wishBook.updateStatus(WishBookStatus.CONFIRMED, reason);
        return WishBookDto.of(wishBook);
    }

    @Transactional
    public WishBookDto completeWishBook(Long id, String reason) {
        WishBook wishBook = wishBookRepository.findById(id)
                .orElseThrow(() -> new WishBookException("해당하는 희망도서를 찾을 수 없습니다."));
        wishBook.complete(reason);
        return WishBookDto.of(wishBook);
    }

    @Transactional
    public WishBookDto holdWishBook(Long id, String reason) {
        WishBook wishBook = wishBookRepository.findById(id)
                .orElseThrow(() -> new WishBookException("해당하는 희망도서를 찾을 수 없습니다."));
        wishBook.updateStatus(WishBookStatus.HELD, reason);
        return WishBookDto.of(wishBook);
    }
}
