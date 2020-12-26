package dev.milzipmoza.tecobrary.core.event.book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookStatusEventHandler {

    @TransactionalEventListener
    public void handleEvent(BookStatusEvent event) {
        log.info("handle event={}", event);
    }
}
