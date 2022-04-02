package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;
    private static Long sequence = 0L;

    @Transactional
    public Long register(Book book, BookKind bookKind) {
        int maxBookCopy = bookRepository.getMaxBookCopy(bookKind.getBookSymbol()); // 해당 청구기호를 가진 도서들 중 가장 큰 복본 값 get
        book.setBookCopy(++maxBookCopy);
        book.setBookKind(bookKind);
        return bookRepository.save(book);
    }

    public List<Book> searchBookList(String bookName, String bookAuthor) {
        List<Book> books;
        if(bookName.equals("") && bookAuthor.equals("")) {
            books = bookRepository.findAll();
        } else if(bookName.equals("")) {
            books = bookRepository.findByAuthor(bookAuthor);
        } else if(bookAuthor.equals("")) {
            books = bookRepository.findByName(bookName);
        } else {
            books = bookRepository.findByNameAndAuthor(bookName, bookAuthor);
        }
        return books;
    }

    public BookKind findBookKind(String bookSymbol) {
        return bookRepository.findByBookSymbol(bookSymbol);
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }
}
