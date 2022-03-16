package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateDto {

    private String userLongPwd;
    private char[] userShortPwd;
    private String userName;
    private String userTel;

    public UserUpdateDto(String userLongPwd, char[] userShortPwd, String userName, String userTel) {
        this.userLongPwd = userLongPwd;
        this.userShortPwd = userShortPwd;
        this.userName = userName;
        this.userTel = userTel;
    }
}
