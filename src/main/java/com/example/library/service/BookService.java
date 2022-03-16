package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private static Long sequence = 0L;

    public Long register(Book book, BookKind bookKind) {
        book.setBookId(++sequence);
        int maxBookCopy = bookRepository.getMaxBookCopy(book.getBookSymbol()); // 해당 청구기호를 가진 도서들 중 가장 큰 복본 값 get
        book.setBookCopy(++maxBookCopy);
        book.setBookKind(bookKind);
        return bookRepository.save(book);
    }

    public List<Book> findBooks() {
        return bookRepository.findAll();
    }
}
