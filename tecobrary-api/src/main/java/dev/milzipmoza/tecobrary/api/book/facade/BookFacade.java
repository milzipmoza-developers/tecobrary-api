package dev.milzipmoza.tecobrary.api.book.facade;

import dev.milzipmoza.tecobrary.api.book.request.BookEnrollRequest;
import dev.milzipmoza.tecobrary.api.book.request.BookListRequest;
import dev.milzipmoza.tecobrary.api.book.request.BookUpdateRequest;
import dev.milzipmoza.tecobrary.api.book.response.BookDetailResponse;
import dev.milzipmoza.tecobrary.api.book.response.BookEnrollResponse;
import dev.milzipmoza.tecobrary.api.book.response.BookPageResponse;
import dev.milzipmoza.tecobrary.api.book.response.BookUpdateResponse;
import dev.milzipmoza.tecobrary.core.domain.book.dto.*;
import dev.milzipmoza.tecobrary.core.domain.book.service.BookCommandService;
import dev.milzipmoza.tecobrary.core.domain.book.service.BookQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookFacade {

    private final BookCommandService bookCommandService;
    private final BookQueryService bookQueryService;

    public BookPageResponse getBooks(BookListRequest request) {
        BookPageDto pageBooks = bookQueryService.getPageBooks(request.getPage(), request.getSize());
        return BookPageResponse.of(pageBooks);
    }

    public BookDetailResponse getBookDetail(Long id) {
        BookDetailDto book = bookQueryService.getBook(id);
        return BookDetailResponse.of(book);
    }

    public BookEnrollResponse enroll(BookEnrollRequest request) {
        BookEnrollDto enrollDto = BookEnrollDto.builder()
                .title(request.getTitle())
                .author(request.getAuthor())
                .publisher(request.getPublisher())
                .isbn(request.getIsbn())
                .image(request.getImage())
                .description(request.getDescription())
                .build();
        BookDto enrolledBook = bookCommandService.enroll(enrollDto);
        return BookEnrollResponse.of(enrolledBook);
    }

    public BookUpdateResponse update(BookUpdateRequest body) {
        BookUpdateDto updateDto = BookUpdateDto.builder()
                .id(body.getId())
                .title(body.getTitle())
                .imageUrl(body.getImage())
                .author(body.getAuthor())
                .publisher(body.getPublisher())
                .description(body.getDescription())
                .build();
        BookDto updatedBook = bookCommandService.update(updateDto);
        return BookUpdateResponse.of(updatedBook);
    }

    public void delete(Long id) {
        log.info("[LibraryBookFacade][delete][{}] 도서 존재 유무 확인", id);
        bookQueryService.existsById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 제거", id);
        bookCommandService.deleteById(id);
        log.info("[LibraryBookFacade][delete][{}] 도서 성공", id);
    }
}
