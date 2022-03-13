package com.example.library.domain;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
public class User {

    @Id
    private String userId;
    private String userLongPwd;
    private char[] userShortPwd;
    private int suspenTerm;
    private String userTel;
    private String userName;

    public User(String userId, String userLongPwd, char[] userShortPwd, String userTel, String userName) {
        this.userId = userId;
        this.userLongPwd = userLongPwd;
        this.userShortPwd = userShortPwd;
        this.suspenTerm = 0;
        this.userTel = userTel;
        this.userName = userName;
    }

    // 전화번호 없는 경우
    public User(String userId, String userLongPwd, char[] userShortPwd, String userName) {
        this.userId = userId;
        this.userLongPwd = userLongPwd;
        this.userShortPwd = userShortPwd;
        this.suspenTerm = 0;
        this.userName = userName;
    }
}
