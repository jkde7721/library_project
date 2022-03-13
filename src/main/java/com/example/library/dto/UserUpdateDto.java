package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateDto {

    private String userLongPwd;
    private char[] userShortPwd;
    private String userTel;
    private String userName;

    public UserUpdateDto(String userLongPwd, char[] userShortPwd, String userTel, String userName) {
        this.userLongPwd = userLongPwd;
        this.userShortPwd = userShortPwd;
        this.userTel = userTel;
        this.userName = userName;
    }
}
