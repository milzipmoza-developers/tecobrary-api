package dev.milzipmoza.tecobrary.core.domain.renthistory.service;

import dev.milzipmoza.tecobrary.core.domain.renthistory.entity.RentHistory;
import dev.milzipmoza.tecobrary.core.domain.renthistory.repository.RentHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentHistoryCommandService {

    private final RentHistoryRepository rentHistoryRepository;

    public void rent(String bookSerial, String memberNumber) {
        RentHistory rentHistory = new RentHistory(memberNumber, bookSerial);
        rentHistoryRepository.save(rentHistory);
    }
}
