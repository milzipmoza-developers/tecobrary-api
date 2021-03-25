package dev.milzipmoza.tecobrary.core.domain.book.repository;

import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, BookCustomRepository {

    Optional<Book> findByBookInfoIsbn(String isbn);
}
