package dev.milzipmoza.tecobrary.core.domain.librarybook.repository;

import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface LibraryBookCustomRepository {
    Optional<LibraryBook> findByIdWithBookOrderAsc(Long libraryBookId);

    Page<LibraryBook> findAllWithBooks(Pageable pageable);
}
