package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface RentCustomRepository {

    Optional<Rent> findNotReturnedByRentMemberNumberAndLibraryBookIdAndBookSerial(String memberNumber, Long libraryBookId, String bookSerial);

    PageImpl<Rent> findAllMemberRents(String memberNumber, PageRequest pageRequest);
}
