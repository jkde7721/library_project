package com.example.library.repository;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

    private static final Map<String, User> userStore = new HashMap<>();

    @Override
    public String save(User user) {
        userStore.put(user.getUserId(), user);
        return user.getUserId();
    }

    @Override
    public boolean login(UserLoginDto userLoginDto) {
        //아이디 검색
        User findUser = userStore.get(userLoginDto.getUserId());
        return (findUser.getUserLongPwd().equals(userLoginDto.getUserLongPwd()));
    }

    @Override
    public User findById(String userId) {
        return userStore.get(userId);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    @Override
    public void updateUser(String userId, UserUpdateDto userUpdateDto) {
        User user = userStore.get(userId);
        user.setUserLongPwd(userUpdateDto.getUserLongPwd());
        user.setUserShortPwd(userUpdateDto.getUserShortPwd());
        user.setUserName(userUpdateDto.getUserName());
        user.setUserTel(userUpdateDto.getUserTel());
    }
}
