package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateDto {

    private String userPwd;
    private String userShortPwd;
    private String userName;
    private String userTel;

    public UserUpdateDto(String userPwd, String userShortPwd, String userName, String userTel) {
        this.userPwd = userPwd;
        this.userShortPwd = userShortPwd;
        this.userName = userName;
        this.userTel = userTel;
    }
}
