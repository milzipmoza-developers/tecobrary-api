package dev.milzipmoza.tecobrary.api.librarybook.response;

import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookElementDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class LibraryBookPageResponse {

    private List<LibraryBookElementDto> books;

    public LibraryBookPageResponse(List<LibraryBookElementDto> books) {
        this.books = books;
    }
}
