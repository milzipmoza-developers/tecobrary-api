package dev.milzipmoza.tecobrary.core.domain.book.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookCustomRepository {
    Optional<Book> findByIdWithBookOrderAsc(Long libraryBookId);

    Page<Book> findAllWithBooks(Pageable pageable);
}
