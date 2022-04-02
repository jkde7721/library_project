package com.example.library.repository;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;

import java.util.List;

public interface UserRepository {

    Long save(User user);
    boolean compareByIdAndPwd(UserLoginDto userLoginDto);
    User findBySeq(Long userSeq);
    List<User> findById(String userId);
    List<User> findByName(String userName);
    List<User> findAll();
    Long updateValue(String userId, UserUpdateDto userUpdateDto);
}
