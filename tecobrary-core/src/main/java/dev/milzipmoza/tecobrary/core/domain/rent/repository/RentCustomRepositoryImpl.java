package dev.milzipmoza.tecobrary.core.domain.rent.repository;

import com.querydsl.core.QueryResults;
import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public PageImpl<Rent> findAllMemberRents(String memberNumber, PageRequest pageable) {
        QueryResults<Rent> results = from(rent)
                .where(rent.rentMemberNumber.eq(memberNumber))
                .orderBy(rent.isReturned.desc())
                .orderBy(rent.rentDateTime.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }
}
