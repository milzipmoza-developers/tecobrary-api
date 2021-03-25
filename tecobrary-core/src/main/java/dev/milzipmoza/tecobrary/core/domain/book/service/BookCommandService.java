package dev.milzipmoza.tecobrary.core.domain.book.service;

import dev.milzipmoza.tecobrary.core.domain.book.dto.BookDto;
import dev.milzipmoza.tecobrary.core.domain.book.dto.BookEnrollDto;
import dev.milzipmoza.tecobrary.core.domain.book.dto.BookUpdateDto;
import dev.milzipmoza.tecobrary.core.domain.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookAlreadyEnrolledException;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookDeletedFailedException;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.book.exception.BookUpdateFailedException;
import dev.milzipmoza.tecobrary.core.domain.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCommandService {

    private final BookRepository bookRepository;

    public BookDto enroll(BookEnrollDto enrollBook) {
        try {
            Book savedBook = bookRepository.save(enrollBook.toEntity());
            return BookDto.of(savedBook);
        } catch (ConstraintViolationException e) {
            throw new BookAlreadyEnrolledException("이미 등록된 도서입니다.");
        }
    }

    public BookDto update(BookUpdateDto updateDto) {
        Book savedBook = bookRepository.findById(updateDto.getId())
                .orElseThrow(() -> new BookNotFoundException(updateDto.getId()));
        try {
            savedBook.updateBookInfo(updateDto.getTitle(), updateDto.getAuthor(), updateDto.getImageUrl(), updateDto.getPublisher(), updateDto.getDescription());
            Book updatedBook = bookRepository.save(savedBook);
            return BookDto.of(updatedBook);
        } catch (Exception e) {
            throw new BookUpdateFailedException("도서 정보 업데이트에 실패하였습니다.");
        }
    }

    public void deleteById(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new BookDeletedFailedException("도서 삭제에 실패하였습니다.");
        }
    }
}
