package dev.milzipmoza.tecobrary.api.admin.librarybook.facade;

import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.service.LibraryBookCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LibraryBookFacade {

    private final LibraryBookCommandService libraryBookCommandService;

    public LibraryBookEnrollResponse enroll(LibraryBookEnrollRequest request) {
        LibraryBookEnrollDto enrollDto = LibraryBookEnrollDto.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .publisher(request.getPublisher())
                .isbn(request.getIsbn())
                .image(request.getImage())
                .description(request.getDescription())
                .build();
        LibraryBookDto enrolledBook = libraryBookCommandService.enroll(enrollDto);
        return LibraryBookEnrollResponse.of(enrolledBook);
    }
}
