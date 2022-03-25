package com.example.library.repository.memory;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

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
                .filter(book -> book.getBookKind().getBookSymbol().equals(bookSymbol))
                .mapToInt(Book::getBookCopy).max()
                .orElse(0);
    }

    @Override
    public Book findById(Long bookId) {
        return bookStore.get(bookId);
    }

    @Override
    public List<Book> findByName(String bookName) {
        return bookStore.values().stream()
                .filter(book -> book.getBookKind().getBookName().equals(bookName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthor(String bookAuthor) {
        return bookStore.values().stream()
                .filter(book -> book.getBookKind().getBookAuthor().equals(bookAuthor))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findByNameAndAuthor(String bookName, String bookAuthor) {
        return bookStore.values().stream()
                .filter(book -> book.getBookKind().getBookName().equals(bookName))
                .filter(book -> book.getBookKind().getBookAuthor().equals(bookAuthor))
                .collect(Collectors.toList());
    }

    @Override
    public BookKind findBySymbol(String bookSymbol) {
        return bookStore.values().stream()
                .map(Book::getBookKind)
                .filter(bookKind -> bookKind.getBookSymbol().equals(bookSymbol))
                .findFirst()
                .orElse(new BookKind());
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }
}
