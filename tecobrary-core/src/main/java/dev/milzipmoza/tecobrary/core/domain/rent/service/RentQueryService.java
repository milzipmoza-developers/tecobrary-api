package dev.milzipmoza.tecobrary.core.domain.rent.service;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import dev.milzipmoza.tecobrary.core.domain.rent.exception.RentNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.rent.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentQueryService {

    private final RentRepository rentRepository;

    public void checkReturnable(String memberNumber, Long libraryBookId, String bookSerial) {
        findNotReturned(memberNumber, libraryBookId, bookSerial);
    }

    private Rent findNotReturned(String memberNumber, Long libraryBookId, String bookSerial) {
        return rentRepository.findNotReturnedByRentMemberNumberAndLibraryBookIdAndBookSerial(memberNumber, libraryBookId, bookSerial)
                .orElseThrow(() -> new RentNotFoundException("대여내역을 확인해주세요."));
    }
}
