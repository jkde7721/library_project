package com.example.library.repository.db;

import com.example.library.domain.Borrow;
import com.example.library.repository.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Primary
public class DbBorrowRepository implements BorrowRepository {

    private final EntityManager em;

    @Override
    public void save(Borrow borrowObj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(borrowObj);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    //양방향 연관관계 매핑으로 의미X
    @Override
    public List<Borrow> findById(String userId) {
        return null;
    }

    @Override
    public String delete(Long bookId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            //JPQL 사용
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return "";
    }
}
