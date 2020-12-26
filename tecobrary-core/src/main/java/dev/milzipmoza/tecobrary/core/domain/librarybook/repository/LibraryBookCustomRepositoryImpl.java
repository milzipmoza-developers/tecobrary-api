package dev.milzipmoza.tecobrary.core.domain.librarybook.repository;

import com.querydsl.jpa.JPQLQueryFactory;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
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
}
