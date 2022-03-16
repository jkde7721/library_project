package com.example.library.service;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String join(User user) {
        userRepository.save(user);
        return user.getUserId();
    }

    public boolean login(UserLoginDto userLoginDto) {
        return userRepository.compareByIdAndPwd(userLoginDto);
    }

    public List<User> findListById(String userId) {
        return userRepository.findById(userId);
    }

    public List<User> findListByName(String userName) {
        return userRepository.findByName(userName);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    public void updateUser(String userId, UserUpdateDto userUpdateDto) {
        userRepository.updateValue(userId, userUpdateDto);
    }
}
