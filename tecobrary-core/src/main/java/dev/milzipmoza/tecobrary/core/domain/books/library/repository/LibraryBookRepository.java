package dev.milzipmoza.tecobrary.core.domain.books.library.repository;

import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long> {
}
