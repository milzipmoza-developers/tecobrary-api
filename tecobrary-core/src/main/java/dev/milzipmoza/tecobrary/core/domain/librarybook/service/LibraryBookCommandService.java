package dev.milzipmoza.tecobrary.core.domain.librarybook.service;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookDeleteFailedException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookEnrollFailedException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.BookSerialAlreadyEnrolledException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.dto.LibraryBookUpdateDto;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookAlreadyEnrolledException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookDeletedFailedException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookUpdateFailedException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.repository.LibraryBookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LibraryBookCommandService {

    private final LibraryBookRepository libraryBookRepository;

    public LibraryBookDto enroll(LibraryBookEnrollDto enrollBook) {
        try {
            LibraryBook savedBook = libraryBookRepository.save(enrollBook.toEntity());
            return LibraryBookDto.of(savedBook);
        } catch (ConstraintViolationException e) {
            throw new LibraryBookAlreadyEnrolledException("이미 등록된 도서입니다.");
        }
    }

    public LibraryBookDto update(LibraryBookUpdateDto updateDto) {
        LibraryBook savedBook = libraryBookRepository.findById(updateDto.getId())
                .orElseThrow(() -> new LibraryBookNotFoundException(updateDto.getId()));
        try {
            savedBook.updateBookInfo(updateDto.getTitle(), updateDto.getAuthor(), updateDto.getImageUrl(), updateDto.getPublisher(), updateDto.getDescription());
            LibraryBook updatedBook = libraryBookRepository.save(savedBook);
            return LibraryBookDto.of(updatedBook);
        } catch (Exception e) {
            throw new LibraryBookUpdateFailedException("도서 정보 업데이트에 실패하였습니다.");
        }
    }

    public void deleteById(Long id) {
        try {
            libraryBookRepository.deleteById(id);
        } catch (Exception e) {
            throw new LibraryBookDeletedFailedException("도서 삭제에 실패하였습니다.");
        }
    }

    @Transactional
    public void addBook(Long libraryBookId, String bookSerial) {
        LibraryBook savedLibraryBook = libraryBookRepository.findById(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        try {
            savedLibraryBook.addBook(bookSerial);
        } catch (ConstraintViolationException e) {
            throw new BookSerialAlreadyEnrolledException("이미 등록된 장서 번호입니다.");
        } catch (Exception e) {
            throw new BookEnrollFailedException("장서 등록에 실패하였습니다.");
        }
    }

    @Transactional
    public void deleteBook(Long libraryBookId, String bookSerial) {
        LibraryBook savedLibraryBook = libraryBookRepository.findById(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        try {
            savedLibraryBook.deleteBook(bookSerial);
        } catch (Exception e) {
            throw new BookDeleteFailedException("장서 삭제에 실패하였습니다.");
        }
    }
}
