package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
@Getter @Setter
public class Admin {

    @Id
    private String adminId;
    private String adminPwd;

    public Admin(String adminId, String adminPwd) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
    }
}
