package dev.milzipmoza.tecobrary.core.domain.wishbook.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQueryFactory;
import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static dev.milzipmoza.tecobrary.core.domain.wishbook.entity.QWishBook.wishBook;

public class WishBookCustomRepositoryImpl extends QuerydslRepositorySupport implements WishBookCustomRepository {

    private final JPQLQueryFactory queryFactory;

    public WishBookCustomRepositoryImpl(JPQLQueryFactory queryFactory) {
        super(WishBook.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public PageImpl<WishBook> findAllByMemberNumber(String memberNumber, PageRequest pageRequest) {
        QueryResults<WishBook> results = from(wishBook)
                .where(wishBook.wishMemberNumber.eq(memberNumber))
                .offset(pageRequest.getOffset())
                .limit(pageRequest.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageRequest, results.getTotal());
    }
}
