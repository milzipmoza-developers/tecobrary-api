package dev.milzipmoza.tecobrary.api.librarybook.request;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookEnrollRequest {

    private String bookSerial;

    public BookEnrollRequest(String bookSerial) {
        this.bookSerial = bookSerial;
    }
}
