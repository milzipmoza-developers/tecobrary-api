package dev.milzipmoza.tecobrary.core.domain.book.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQueryFactory;
import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static dev.milzipmoza.tecobrary.core.domain.book.entity.QBook.book;

public class BookCustomRepositoryImpl extends QuerydslRepositorySupport implements BookCustomRepository {

    private final JPQLQueryFactory queryFactory;

    public BookCustomRepositoryImpl(JPQLQueryFactory queryFactory) {
        super(Book.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<Book> findByIdWithBookOrderAsc(Long bookId) {
        return Optional.ofNullable(
                from(book)
                        .fetchJoin()
                        .where(book.id.eq(bookId))
                        .fetchOne()
        );
    }

    @Override
    public Page<Book> findAllWithBooks(Pageable pageable) {
        QueryResults<Book> results = from(book)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
