package dev.milzipmoza.tecobrary.api.librarybook.facade;

import dev.milzipmoza.tecobrary.api.librarybook.dto.*;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookUpdateDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookCommandService;
import dev.milzipmoza.tecobrary.core.domain.librarybook.service.LibraryBookQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class LibraryBookFacade {

    private final LibraryBookCommandService libraryBookCommandService;
    private final LibraryBookQueryService libraryBookQueryService;

    public LibraryBookListResponse getBooks(LibraryBookListRequest request) {
        List<LibraryBookDto> books = libraryBookQueryService.getPageBooks(request.getPage(), request.getSize());
        return new LibraryBookListResponse(books);
    }

    public LibraryBookDetailResponse getBookDetail(Long id) {
        LibraryBookDetailDto book = libraryBookQueryService.getBook(id);
        return LibraryBookDetailResponse.of(book);
    }

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
