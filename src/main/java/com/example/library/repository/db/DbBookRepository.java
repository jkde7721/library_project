package com.example.library.repository.db;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DbBookRepository implements BookRepository {

    private final EntityManager em;

    @Override
    public Long save(Book book) {
        List<BookKind> resultList = em.createQuery("select bk from BookKind bk where bk.bookSymbol = :bookSymbol", BookKind.class)
                .setParameter("bookSymbol", book.getBookKind().getBookSymbol())
                .getResultList();
        if(resultList.size() == 0) em.persist(book.getBookKind()); //등록되어 있지 않은 도서 종류
        else book.setBookKind(resultList.get(0)); //이미 등록되어 있는 도서 종류
        em.persist(book);
        return book.getBookId();
    }

    @Override
    public int getMaxBookCopy(String bookSymbol) {
        Long maxBookCopy = em.createQuery("select count(b) from Book b join b.bookKind bk on bk.bookSymbol = :bookSymbol", Long.class)
                .setParameter("bookSymbol", bookSymbol)
                .getSingleResult();
        return maxBookCopy.intValue();
    }

    @Override
    public Book findById(Long bookId) {
        return em.find(Book.class, bookId);
    }

    @Override
    public List<Book> findByName(String bookName) {
        List<Book> books = em.createQuery("select b from Book b join b.bookKind bk on bk.bookName = :bookName", Book.class)
                .setParameter("bookName", bookName)
                .getResultList();
        return books;
    }

    @Override
    public List<Book> findByAuthor(String bookAuthor) {
        List<Book> books = em.createQuery("select b from Book b join b.bookKind bk on bk.bookAuthor = :bookAuthor", Book.class)
                .setParameter("bookAuthor", bookAuthor)
                .getResultList();
        return books;
    }

    @Override
    public List<Book> findByNameAndAuthor(String bookName, String bookAuthor) {
        List<Book> books = em.createQuery("select b from Book b join b.bookKind bk on bk.bookName = :bookName and bk.bookAuthor = :bookAuthor", Book.class)
                .setParameter("bookName", bookName)
                .setParameter("bookAuthor", bookAuthor)
                .getResultList();
        return books;
    }

    @Override
    public BookKind findByBookSymbol(String bookSymbol) {
        try {
            BookKind findBookKind = em.createQuery("select bk from BookKind bk where bk.bookSymbol = :bookSymbol", BookKind.class)
                    .setParameter("bookSymbol", bookSymbol)
                    .getSingleResult();
            return findBookKind;
        } catch(NoResultException e) {
            return new BookKind();
        }
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("select b from Book b join fetch b.bookKind", Book.class).getResultList();
    }
}
