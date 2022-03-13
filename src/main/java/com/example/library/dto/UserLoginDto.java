package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginDto {

    private String userId;
    private String userLongPwd;

    public UserLoginDto(String userId, String userLongPwd) {
        this.userId = userId;
        this.userLongPwd = userLongPwd;
    }
}
