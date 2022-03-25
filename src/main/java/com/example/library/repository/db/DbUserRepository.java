package com.example.library.repository.db;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Primary
public class DbUserRepository implements UserRepository {

    private final EntityManager em;

    @Override
    public String save(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return user.getUserId();
    }

    @Override
    public boolean compareByIdAndPwd(UserLoginDto userLoginDto) {
        User user = em.find(User.class, userLoginDto.getUserId());
        return (user.getUserLongPwd().equals(userLoginDto.getUserLongPwd()));
    }

    @Override
    public List<User> findById(String userId) {
        User user = em.find(User.class, userId);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

    //JPQL 사용
    @Override
    public List<User> findByName(String userName) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = em.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    public void updateValue(String userId, UserUpdateDto userUpdateDto) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            User user = em.find(User.class, userId);
            user.setUserLongPwd(userUpdateDto.getUserLongPwd());
            user.setUserShortPwd(userUpdateDto.getUserShortPwd());
            user.setUserName(userUpdateDto.getUserName());
            user.setUserTel(userUpdateDto.getUserTel());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
