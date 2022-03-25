package com.example.library.repository;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;

import java.util.List;

public interface BookRepository {

    Long save(Book book);
    int getMaxBookCopy(String bookSymbol);
    Book findById(Long bookId);
    List<Book> findByName(String bookName);
    List<Book> findByAuthor(String bookAuthor);
    List<Book> findByNameAndAuthor(String bookName, String bookAuthor);
    BookKind findBySymbol(String bookSymbol);
    List<Book> findAll();
}
