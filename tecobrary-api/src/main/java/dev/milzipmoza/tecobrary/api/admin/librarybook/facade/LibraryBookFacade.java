package dev.milzipmoza.tecobrary.api.admin.librarybook.facade;

import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookUpdateRequest;
import dev.milzipmoza.tecobrary.api.admin.librarybook.dto.LibraryBookUpdateResponse;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookUpdateDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.service.LibraryBookCommandService;
import dev.milzipmoza.tecobrary.core.domain.books.library.service.LibraryBookQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class LibraryBookFacade {

    private final LibraryBookCommandService libraryBookCommandService;
    private final LibraryBookQueryService libraryBookQueryService;

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

    public LibraryBookUpdateResponse update(LibraryBookUpdateRequest body) {
        LibraryBookUpdateDto updateDto = LibraryBookUpdateDto.builder()
                .id(body.getId())
                .title(body.getTitle())
                .imageUrl(body.getImage())
                .author(body.getAuthor())
                .publisher(body.getPublisher())
                .description(body.getDescription())
                .build();
        LibraryBookDto updatedBook = libraryBookCommandService.update(updateDto);
        return LibraryBookUpdateResponse.of(updatedBook);
    }

    public void delete(Long id) {
        log.info("[LibraryBookFacade][delete][{}] 도서 존재 유무 확인", id);
        libraryBookQueryService.existsById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 제거", id);
        libraryBookCommandService.deleteById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 성공", id);
    }
}
