package com.example.library.repository;

import com.example.library.domain.Book;

import java.util.List;

public interface BookRepository {

    Long save(Book book);
    int getMaxBookCopy(String bookSymbol);
    Book findById(Long bookId);
    List<Book> findAll();
}
