package com.example.library.repository;

import com.example.library.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class MemoryBookRepository implements BookRepository {

    private static final Map<Long, Book> bookStore = new HashMap<>();

    @Override
    public Long save(Book book) {
        bookStore.put(book.getBookId(), book);
        return book.getBookId();
    }

    @Override
    public int getMaxBookCopy(String bookSymbol) {
        return bookStore.values().stream()
                .filter(book -> book.getBookSymbol().equals(bookSymbol))
                .mapToInt(Book::getBookCopy).max()
                .orElse(0);
    }

    @Override
    public Book findById(Long bookId) {
        return bookStore.get(bookId);
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }
}
