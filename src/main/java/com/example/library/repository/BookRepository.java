package com.example.library.repository;

import com.example.library.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findAll();
}
