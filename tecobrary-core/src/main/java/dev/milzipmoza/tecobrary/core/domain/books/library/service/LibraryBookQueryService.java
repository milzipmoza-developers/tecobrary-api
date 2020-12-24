package dev.milzipmoza.tecobrary.core.domain.books.library.service;

import dev.milzipmoza.tecobrary.core.domain.books.library.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.books.library.repository.LibraryBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryBookQueryService {

    private final LibraryBookRepository libraryBookRepository;

    public void existsById(Long id) {
        boolean exists = libraryBookRepository.existsById(id);
        if (!exists) {
            throw new LibraryBookNotFoundException(id);
        }
    }
}
