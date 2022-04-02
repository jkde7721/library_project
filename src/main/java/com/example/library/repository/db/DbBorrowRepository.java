package com.example.library.repository.db;

import com.example.library.domain.Borrow;
import com.example.library.repository.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DbBorrowRepository implements BorrowRepository {

    public final EntityManager em;

    @Override
    public Long save(Borrow borrowObj) {
        em.persist(borrowObj);
        return borrowObj.getBorrowId();
    }

    @Override
    public List<Borrow> findByUserId(String userId) {
        List<Borrow> borrows = em.createQuery("select br from Borrow br join User u on u.userId = :userId", Borrow.class)
                .setParameter("userId", userId)
                .getResultList();
        return borrows;
    }

    /**
     * @param bookId
     * @return userSeq
     */
    @Override
    public Long delete(Long bookId) {
        try {
            Borrow findBorrow = em.createQuery("select br from Borrow br join fetch br.user where exists(select b from br join br.book b where b.bookId = :bookId)", Borrow.class)
                    .setParameter("bookId", bookId)
                    .getSingleResult();
            Long userSeq = findBorrow.getUser().getUserSeq();
            em.remove(findBorrow); //delete query
            return userSeq; //이용자 일련번호 반환
        } catch(NoResultException e) {
            return -1L;
        }
    }
}
