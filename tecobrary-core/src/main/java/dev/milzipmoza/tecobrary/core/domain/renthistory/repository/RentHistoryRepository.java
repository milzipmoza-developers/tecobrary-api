package dev.milzipmoza.tecobrary.core.domain.renthistory.repository;

import dev.milzipmoza.tecobrary.core.domain.renthistory.entity.RentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentHistoryRepository extends JpaRepository<RentHistory, Long> {

    Optional<RentHistory> findByRentBookSerialAndRentMemberNumber(String rentBookSerial, String rentMemberNumber);
}
