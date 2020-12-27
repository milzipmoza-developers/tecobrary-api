package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

    Optional<Rent> findByRentBookSerialAndRentMemberNumber(String rentBookSerial, String rentMemberNumber);
}
