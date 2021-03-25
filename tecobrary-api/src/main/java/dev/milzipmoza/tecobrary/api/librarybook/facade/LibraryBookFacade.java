package dev.milzipmoza.tecobrary.api.librarybook.facade;

import dev.milzipmoza.tecobrary.api.librarybook.request.LibraryBookEnrollRequest;
import dev.milzipmoza.tecobrary.api.librarybook.request.LibraryBookListRequest;
import dev.milzipmoza.tecobrary.api.librarybook.request.LibraryBookUpdateRequest;
import dev.milzipmoza.tecobrary.api.librarybook.response.LibraryBookDetailResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.LibraryBookEnrollResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.LibraryBookPageResponse;
import dev.milzipmoza.tecobrary.api.librarybook.response.LibraryBookUpdateResponse;
import dev.milzipmoza.tecobrary.core.domain.book.dto.*;
import dev.milzipmoza.tecobrary.core.domain.book.service.BookCommandService;
import dev.milzipmoza.tecobrary.core.domain.book.service.BookQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class LibraryBookFacade {

    private final BookCommandService bookCommandService;
    private final BookQueryService bookQueryService;

    public LibraryBookPageResponse getBooks(LibraryBookListRequest request) {
        List<BookElementDto> books = bookQueryService.getPageBooks(request.getPage(), request.getSize());
        return new LibraryBookPageResponse(books);
    }

    public LibraryBookDetailResponse getBookDetail(Long id) {
        BookDetailDto book = bookQueryService.getBook(id);
        return LibraryBookDetailResponse.of(book);
    }

    public LibraryBookEnrollResponse enroll(LibraryBookEnrollRequest request) {
        BookEnrollDto enrollDto = BookEnrollDto.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .publisher(request.getPublisher())
                .isbn(request.getIsbn())
                .image(request.getImage())
                .description(request.getDescription())
                .build();
        BookDto enrolledBook = bookCommandService.enroll(enrollDto);
        return LibraryBookEnrollResponse.of(enrolledBook);
    }

    public LibraryBookUpdateResponse update(LibraryBookUpdateRequest body) {
        BookUpdateDto updateDto = BookUpdateDto.builder()
                .id(body.getId())
                .title(body.getTitle())
                .imageUrl(body.getImage())
                .author(body.getAuthor())
                .publisher(body.getPublisher())
                .description(body.getDescription())
                .build();
        BookDto updatedBook = bookCommandService.update(updateDto);
        return LibraryBookUpdateResponse.of(updatedBook);
    }

    public void delete(Long id) {
        log.info("[LibraryBookFacade][delete][{}] 도서 존재 유무 확인", id);
        bookQueryService.existsById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 제거", id);
        bookCommandService.deleteById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 성공", id);
    }
}
