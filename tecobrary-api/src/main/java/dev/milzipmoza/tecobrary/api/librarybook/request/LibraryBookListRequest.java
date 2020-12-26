package dev.milzipmoza.tecobrary.api.librarybook.request;

import lombok.Getter;

@Getter
public class LibraryBookListRequest {
    private final int page;
    private final int size;

    public LibraryBookListRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }
}
