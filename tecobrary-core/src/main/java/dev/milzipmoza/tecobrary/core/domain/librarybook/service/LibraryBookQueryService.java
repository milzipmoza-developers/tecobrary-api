package dev.milzipmoza.tecobrary.core.domain.librarybook.service;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookSerialNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.repository.LibraryBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryBookQueryService {

    private final LibraryBookRepository libraryBookRepository;

    public List<LibraryBookDto> getPageLibraryBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<LibraryBook> books = libraryBookRepository.findAll(pageRequest);
        return books.stream()
                .map(LibraryBookDto::of)
                .collect(Collectors.toList());
    }

    public LibraryBookDetailDto getLibraryBook(Long id) {
        LibraryBook libraryBook = libraryBookRepository.findByIdWithBookOrderAsc(id)
                .orElseThrow(() -> new LibraryBookNotFoundException(id));
        return LibraryBookDetailDto.of(libraryBook);
    }

    public void existsById(Long id) {
        boolean exists = libraryBookRepository.existsById(id);
        if (!exists) {
            throw new LibraryBookNotFoundException(id);
        }
    }

    public BookDetailDto getBookDetail(Long libraryBookId) {
        LibraryBook libraryBook = libraryBookRepository.findByIdWithBookOrderAsc(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        return BookDetailDto.of(libraryBook);
    }

    public BookDto getBook(Long libraryBookId, String bookSerial) {
        LibraryBook libraryBook = libraryBookRepository.findByIdWithBookOrderAsc(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        Book book = libraryBook.findBookBySerial(bookSerial)
                .orElseThrow(() -> new BookSerialNotFoundException("해당하는 장서가 존재하지 않습니다."));
        ;
        return BookDto.of(book);
    }
}
