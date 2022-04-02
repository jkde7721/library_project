package com.example.library.repository.db;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DbUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public Long save(User user) {
        em.persist(user);
        return user.getUserSeq();
    }

    @Override
    public boolean compareByIdAndPwd(UserLoginDto userLoginDto) {
        List<User> resultList = em.createQuery("select u from User u where u.userId = :userId and u.userPwd = :userPwd", User.class)
                .setParameter("userId", userLoginDto.getUserId())
                .setParameter("userPwd", userLoginDto.getUserPwd())
                .getResultList();
        if(resultList.size() == 0) return false;
        return true;
    }

    @Override
    public User findBySeq(Long userSeq) {
        return em.find(User.class, userSeq);
    }

    @Override
    public List<User> findById(String userId) {
        List<User> users = em.createQuery("select u from User u where u.userId = :userId", User.class)
                .setParameter("userId", userId)
                .getResultList();
        return users;
    }

    @Override
    public List<User> findByName(String userName) {
        List<User> users = em.createQuery("select u from User u where u.userName = :userName", User.class)
                .setParameter("userName", userName)
                .getResultList();
        return users;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public Long updateValue(String userId, UserUpdateDto userUpdateDto) {
        //벌크연산 필요 없음 -> 엔티티 하나에 대해서만 update
        try {
            User findUser = em.createQuery("select u from User u where u.userId = :userId", User.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
            findUser.setUserPwd(userUpdateDto.getUserPwd());
            findUser.setUserShortPwd(userUpdateDto.getUserShortPwd());
            findUser.setUserName(userUpdateDto.getUserName());
            findUser.setUserTel(userUpdateDto.getUserTel());
            return findUser.getUserSeq();
        } catch (NoResultException e) {
            return -1L;
        }
    }
}
