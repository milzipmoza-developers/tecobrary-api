package dev.milzipmoza.tecobrary.core.event.book;

import lombok.Getter;

@Getter
public class BookStatusEvent {

    private final String memberNumber;
    private final String bookSerial;

    public BookStatusEvent(String memberNumber, String bookSerial) {
        this.memberNumber = memberNumber;
        this.bookSerial = bookSerial;
    }
}
