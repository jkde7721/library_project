package com.example.library.service;

import com.example.library.domain.User;
import com.example.library.dto.UserLoginDto;
import com.example.library.dto.UserUpdateDto;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        userRepository.save(user);
        return user.getUserSeq();
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

    @Transactional
    public void updateUser(String userId, UserUpdateDto userUpdateDto) {
        userRepository.updateValue(userId, userUpdateDto);
    }
}
