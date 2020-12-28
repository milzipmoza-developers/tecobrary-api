package dev.milzipmoza.tecobrary.core.domain.librarybook.repository;

import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long>, LibraryBookCustomRepository {

    Optional<LibraryBook> findByBookInfoIsbn(String isbn);
}
