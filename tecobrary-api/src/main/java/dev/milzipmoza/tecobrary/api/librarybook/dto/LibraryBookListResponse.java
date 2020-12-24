package dev.milzipmoza.tecobrary.api.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LibraryBookListResponse {

    private List<LibraryBookDto> books;

    public LibraryBookListResponse(List<LibraryBookDto> books) {
        this.books = books;
    }
}
