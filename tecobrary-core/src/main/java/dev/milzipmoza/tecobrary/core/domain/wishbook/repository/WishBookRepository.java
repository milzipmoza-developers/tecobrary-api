package dev.milzipmoza.tecobrary.core.domain.wishbook.repository;

import dev.milzipmoza.tecobrary.core.domain.wishbook.entity.WishBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishBookRepository extends JpaRepository<WishBook, Long> {
}
