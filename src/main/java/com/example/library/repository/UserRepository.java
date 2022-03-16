package com.example.library.repository;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    String save(User user);
    boolean login(UserLoginDto userLoginDto);
    User findById(String userId);
    List<User> findAll();
    void updateUser(String userId, UserUpdateDto userUpdateDto);
}
