package dev.milzipmoza.tecobrary.core.domain.book.service;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.book.dto.BookElementDto;
import dev.milzipmoza.tecobrary.core.domain.book.dto.BookPageDto;
import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookQueryService {

    private final BookRepository bookRepository;

    public BookPageDto getPageBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Book> books = bookRepository.findAllWithBooks(pageRequest);
        return BookPageDto.builder()
                .isFirstPage(books.isFirst())
                .isLastPage(books.isLast())
                .resultCounts(books.getNumberOfElements())
                .books(books.stream()
                        .map(BookElementDto::of)
                        .collect(Collectors.toList()))
                .build();
    }

    public BookDetailDto getBook(Long id) {
        Book book = bookRepository.findByIdWithBookOrderAsc(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return BookDetailDto.of(book);
    }

    public void existsById(Long id) {
        boolean exists = bookRepository.existsById(id);
        if (!exists) {
            throw new BookNotFoundException(id);
        }
    }
}
