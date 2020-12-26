package dev.milzipmoza.tecobrary.core.event.book;

import dev.milzipmoza.tecobrary.core.domain.renthistory.service.RentHistoryCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookStatusEventHandler {

    private final RentHistoryCommandService rentHistoryCommandService;

    @TransactionalEventListener
    public void handleEvent(BookStatusEvent event) {
        log.info("handle event={}", event);
        if (event.isRentEvent()) {
            rentHistoryCommandService.rent(event.getBookSerial(), event.getMemberNumber());
        }
    }
}
