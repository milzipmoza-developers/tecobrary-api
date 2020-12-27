package dev.milzipmoza.tecobrary.core.domain.rent.service;

import dev.milzipmoza.tecobrary.core.domain.rent.entity.Rent;
import dev.milzipmoza.tecobrary.core.domain.rent.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RentCommandService {

    private final RentRepository rentRepository;

    public void doRent(Long libraryBookId, String libraryBookTitle, String libraryBookPublisher, String bookSerial, String memberNumber) {
        Rent rent = Rent.doRent(libraryBookId, libraryBookTitle, libraryBookPublisher, memberNumber, bookSerial);
        rentRepository.save(rent);
    }

    public void doReturn(String bookSerial, String memberNumber) {
        Rent rent = rentRepository.findByRentBookSerialAndRentMemberNumber(bookSerial, memberNumber)
                .orElse(null);
        if (rent == null) {
            log.warn("[RentHistoryCommandService][doReturn] 존재하지 않는 대여 내역 bookSerial={}, memberNumber={}", bookSerial, memberNumber);
            return;
        }
        rent.doReturn();
    }
}
