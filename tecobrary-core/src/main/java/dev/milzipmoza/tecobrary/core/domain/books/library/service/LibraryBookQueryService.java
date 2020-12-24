package dev.milzipmoza.tecobrary.core.domain.books.library.service;

import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDetailDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.books.library.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.books.library.repository.LibraryBookRepository;
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

    public List<LibraryBookDto> getPageBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<LibraryBook> books = libraryBookRepository.findAll(pageRequest);
        return books.stream()
                .map(LibraryBookDto::of)
                .collect(Collectors.toList());
    }

    public LibraryBookDetailDto getBook(Long id) {
        LibraryBook libraryBook = libraryBookRepository.findById(id)
                .orElseThrow(() -> new LibraryBookNotFoundException(id));
        return LibraryBookDetailDto.of(libraryBook);
    }

    public void existsById(Long id) {
        boolean exists = libraryBookRepository.existsById(id);
        if (!exists) {
            throw new LibraryBookNotFoundException(id);
        }
    }
}
