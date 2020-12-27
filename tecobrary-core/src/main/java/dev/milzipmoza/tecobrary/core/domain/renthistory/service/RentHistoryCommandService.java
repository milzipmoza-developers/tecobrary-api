package dev.milzipmoza.tecobrary.core.domain.renthistory.service;

import dev.milzipmoza.tecobrary.core.domain.renthistory.entity.RentHistory;
import dev.milzipmoza.tecobrary.core.domain.renthistory.repository.RentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentHistoryCommandService {

    private final RentHistoryRepository rentHistoryRepository;

    public void doRent(String bookSerial, String memberNumber) {
        RentHistory rentHistory = RentHistory.doRent(memberNumber, bookSerial);
        rentHistoryRepository.save(rentHistory);
    }

    public void doReturn(String bookSerial, String memberNumber) {
        rentHistoryRepository.findByRentBookSerialAndRentMemberNumber(bookSerial, memberNumber)
                .ifPresent(RentHistory::doReturn);
    }
}
