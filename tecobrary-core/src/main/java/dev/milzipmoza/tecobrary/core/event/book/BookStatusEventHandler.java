package dev.milzipmoza.tecobrary.core.event.book;

import dev.milzipmoza.tecobrary.core.domain.rent.service.RentCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookStatusEventHandler {

    private final RentCommandService rentCommandService;

    @TransactionalEventListener
    public void handleEvent(BookStatusEvent event) {
        log.info("handle event={}", event);
        if (event.isRentEvent()) {
            rentCommandService.doRent(event.getLibraryBookId(), event.getLibraryBookTitle(), event.getLibraryBookPublisher(), event.getBookSerial(), event.getMemberNumber());
        } else if (event.isReturnEvent()) {
            rentCommandService.doReturn(event.getLibraryBookId(), event.getBookSerial(), event.getMemberNumber());
        }
    }
}
