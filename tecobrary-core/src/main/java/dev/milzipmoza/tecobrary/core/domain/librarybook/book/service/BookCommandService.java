package dev.milzipmoza.tecobrary.core.domain.librarybook.book.service;

import dev.milzipmoza.tecobrary.core.domain.librarybook.book.entity.Book;
import dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception.*;
import dev.milzipmoza.tecobrary.core.domain.librarybook.entity.LibraryBook;
import dev.milzipmoza.tecobrary.core.domain.librarybook.exception.LibraryBookNotFoundException;
import dev.milzipmoza.tecobrary.core.domain.librarybook.repository.LibraryBookRepository;
import dev.milzipmoza.tecobrary.core.event.book.BookStatusEvent;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class BookCommandService {

    private final LibraryBookRepository libraryBookRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

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

    public void deleteBook(Long libraryBookId, String bookSerial) {
        LibraryBook savedLibraryBook = libraryBookRepository.findById(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        try {
            savedLibraryBook.deleteBook(bookSerial);
        } catch (Exception e) {
            throw new BookDeleteFailedException("장서 삭제에 실패하였습니다.");
        }
    }

    public void rentBook(String rentMemberNumber, Long libraryBookId, String bookSerial) {
        LibraryBook rentLibraryBook = libraryBookRepository.findByIdWithBookOrderAsc(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        try {
            Book book = rentLibraryBook.rentBook(bookSerial, rentMemberNumber);
            applicationEventPublisher.publishEvent(BookStatusEvent.builder()
                    .libraryBookId(rentLibraryBook.getId())
                    .libraryBookTitle(rentLibraryBook.getBookInfo().getTitle())
                    .libraryBookPublisher(rentLibraryBook.getBookInfo().getPublisher())
                    .bookSerial(book.getBookSerial())
                    .bookStatus(book.getBookStatus())
                    .memberNumber(rentMemberNumber)
                    .build());
        } catch (BookException e) {
            throw e;
        } catch (Exception e) {
            throw new BookRentFailedException("장서 대여에 실패하였습니다.");
        }
    }

    public void returnBook(String rentMemberNumber, Long libraryBookId, String bookSerial) {
        LibraryBook returnLibraryBook = libraryBookRepository.findById(libraryBookId)
                .orElseThrow(() -> new LibraryBookNotFoundException(libraryBookId));
        try {
            Book book = returnLibraryBook.returnBook(bookSerial, rentMemberNumber);
            applicationEventPublisher.publishEvent(BookStatusEvent.builder()
                    .libraryBookId(returnLibraryBook.getId())
                    .libraryBookTitle(returnLibraryBook.getBookInfo().getTitle())
                    .libraryBookPublisher(returnLibraryBook.getBookInfo().getPublisher())
                    .bookSerial(book.getBookSerial())
                    .bookStatus(book.getBookStatus())
                    .memberNumber(rentMemberNumber)
                    .build());
        } catch (BookException e) {
            throw e;
        } catch (Exception e) {
            throw new BookReturnFailedException("장서 반납에 실패하였습니다.");
        }
    }
}
