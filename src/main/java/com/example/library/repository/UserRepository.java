package com.example.library.repository;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;

import java.util.List;

public interface UserRepository {

    String save(User user);
    boolean compareByIdAndPwd(UserLoginDto userLoginDto);
    List<User> findById(String userId);
    List<User> findByName(String userName);
    List<User> findAll();
    void updateValue(String userId, UserUpdateDto userUpdateDto);
}
