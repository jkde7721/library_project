package com.example.library.repository.db;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Primary
public class DbBookRepository implements BookRepository {

    private final EntityManager em;

    @Override
    public Long save(Book book) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(book);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return book.getBookId();
    }

    @Override
    public int getMaxBookCopy(String bookSymbol) {
        return 0;
    }

    @Override
    public Book findById(Long bookId) {
        Book book = em.find(Book.class, bookId);
        return book;
    }

    //JPQL 사용... (Join)
    @Override
    public List<Book> findByName(String bookName) {
        //em.createQuery("select b from Book b join BookKind bk where b.bookKind.bookSymbol = bk.bookSymbol and bk.bookName = ")
        return null;
    }

    @Override
    public List<Book> findByAuthor(String bookAuthor) {
        return null;
    }

    @Override
    public List<Book> findByNameAndAuthor(String bookName, String bookAuthor) {
        return null;
    }

    @Override
    public BookKind findBySymbol(String bookSymbol) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = em.createQuery("select b from Book b", Book.class).getResultList();
        return books;
    }
}
