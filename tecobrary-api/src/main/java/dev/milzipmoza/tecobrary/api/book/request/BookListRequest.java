package dev.milzipmoza.tecobrary.api.book.request;

import lombok.Getter;

@Getter
public class BookListRequest {
    private final int page;
    private final int size;

    public BookListRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
