package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.Optional;

import static dev.milzipmoza.tecobrary.core.domain.rent.entity.QRent.rent;

public class RentCustomRepositoryImpl extends QuerydslRepositorySupport implements RentCustomRepository {

    public RentCustomRepositoryImpl() {
        super(Rent.class);
    }

    @Override
    public Optional<Rent> findNotReturnedByRentMemberNumberAndLibraryBookIdAndBookSerial(String memberNumber, Long libraryBookId, String bookSerial) {
        return Optional.ofNullable(
                from(rent)
                        .where(rent.isReturned.eq(false))
                        .where(rent.rentMemberNumber.eq(memberNumber))
                        .where(rent.rentLibraryBookId.eq(libraryBookId))
                        .where(rent.rentBookSerial.eq(bookSerial))
                        .fetchOne()
        );
    }
}
