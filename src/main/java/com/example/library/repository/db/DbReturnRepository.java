package com.example.library.repository.db;

import com.example.library.domain.Return;
import com.example.library.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Primary
public class DbReturnRepository implements ReturnRepository {

    private final EntityManager em;

    @Override
    public void save(Return returnObj) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(returnObj);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    //양방향 연관관계 매핑으로 의미X
    @Override
    public List<Return> findById(String userId) {
        return null;
    }
}
