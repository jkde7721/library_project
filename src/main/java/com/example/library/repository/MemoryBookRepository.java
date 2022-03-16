package com.example.library.repository;

import com.example.library.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryBookRepository implements BookRepository {

    private static final Map<Long, Book> bookStore = new HashMap<>();

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }
}
