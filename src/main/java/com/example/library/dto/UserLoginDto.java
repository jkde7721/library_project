package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginDto {

    private String userId;
    private String userPwd;

    public UserLoginDto(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }
}
