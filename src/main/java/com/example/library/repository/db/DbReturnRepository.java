package com.example.library.repository.db;

import com.example.library.domain.Return;
import com.example.library.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DbReturnRepository implements ReturnRepository {

    private final EntityManager em;

    @Override
    public Long save(Return returnObj) {
        em.persist(returnObj);
        return returnObj.getReturnId();
    }

    @Override
    public List<Return> findByUserId(String userId) {
        List<Return> returns = em.createQuery("select rt from Return rt join rt.user u on u.userId = :userId", Return.class)
                .setParameter("userId", userId)
                .getResultList();
        return returns;
    }
}
