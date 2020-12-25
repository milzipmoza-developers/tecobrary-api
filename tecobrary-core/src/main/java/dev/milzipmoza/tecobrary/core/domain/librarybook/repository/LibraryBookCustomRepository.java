package dev.milzipmoza.tecobrary.core.domain.librarybook.repository;

import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;

import java.util.Optional;

public interface LibraryBookCustomRepository {
    Optional<LibraryBook> findByIdWithBook(Long libraryBookId);
}
