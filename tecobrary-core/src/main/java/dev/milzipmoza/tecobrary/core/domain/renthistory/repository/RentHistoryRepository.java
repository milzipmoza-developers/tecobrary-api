package dev.milzipmoza.tecobrary.core.domain.renthistory.repository;

import dev.milzipmoza.tecobrary.core.domain.renthistory.entity.RentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentHistoryRepository extends JpaRepository<RentHistory, Long> {
}
