package dev.milzipmoza.tecobrary.core.domain.wishbook.service;

import dev.milzipmoza.tecobrary.core.domain.wishbook.dto.WishBookPageDto;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBookStatus;
import dev.milzipmoza.tecobrary.core.domain.wishbook.repository.WishBookRepository;
import dev.milzipmoza.tecobrary.core.domain.wishbook.repository.clause.WishBookClause;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WishBookQueryService {

    private final WishBookRepository wishBookRepository;

    public WishBookPageDto getMemberPageWishBooks(String memberNumber, int page, int size) {
        PageImpl<WishBook> wishBooks = wishBookRepository.findAllByMemberNumber(memberNumber, PageRequest.of(page - 1, size));
        return WishBookPageDto.of(wishBooks);
    }

    public WishBookPageDto getConditionalPageWishBooks(WishBookStatus status, int page, int size) {
        PageImpl<WishBook> wishBooks = wishBookRepository.findAll(new WishBookClause(status), PageRequest.of(page - 1, size));
        return WishBookPageDto.of(wishBooks);
    }
}
