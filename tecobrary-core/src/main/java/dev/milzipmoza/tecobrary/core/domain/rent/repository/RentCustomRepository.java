package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;

import java.util.Optional;

public interface RentCustomRepository {

    Optional<Rent> findNotReturnedByRentMemberNumberAndLibraryBookIdAndBookSerial(String memberNumber, Long libraryBookId, String bookSerial);
}
