package dev.milzipmoza.tecobrary.core.domain.librarybook.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.JPQLQueryFactory;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.QBook.book;
import static dev.milzipmoza.tecobrary.core.domain.librarybook.entity.QLibraryBook.libraryBook;

public class LibraryBookCustomRepositoryImpl extends QuerydslRepositorySupport implements LibraryBookCustomRepository {

    private final JPQLQueryFactory queryFactory;

    public LibraryBookCustomRepositoryImpl(JPQLQueryFactory queryFactory) {
        super(LibraryBook.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public Optional<LibraryBook> findByIdWithBookOrderAsc(Long libraryBookId) {
        return Optional.ofNullable(
                from(libraryBook)
                        .leftJoin(libraryBook.books, book)
                        .fetchJoin()
                        .orderBy(book.bookSerial.asc())
                        .where(libraryBook.id.eq(libraryBookId))
                        .fetchOne()
        );
    }

    @Override
    public Page<LibraryBook> findAllWithBooks(Pageable pageable) {
        QueryResults<LibraryBook> results = from(libraryBook)
                .innerJoin(libraryBook.books, book)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
