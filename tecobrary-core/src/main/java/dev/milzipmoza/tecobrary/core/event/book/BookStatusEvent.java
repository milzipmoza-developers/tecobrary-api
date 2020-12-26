package dev.milzipmoza.tecobrary.core.event.book;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.BookStatus;
import lombok.Getter;

@Getter
public class BookStatusEvent {

    private final String memberNumber;
    private final String bookSerial;
    private final BookStatus bookStatus;

    public BookStatusEvent(String memberNumber, String bookSerial, BookStatus bookStatus) {
        this.memberNumber = memberNumber;
        this.bookSerial = bookSerial;
        this.bookStatus = bookStatus;
    }

    public boolean isRentEvent() {
        return this.bookStatus == BookStatus.RENT;
    }
}
