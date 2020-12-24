package dev.milzipmoza.tecobrary.api.admin.librarybook.dto;

import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDto;
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
