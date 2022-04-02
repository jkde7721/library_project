package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AdminLoginDto {

    private String adminId;
    private String adminPwd;

    public AdminLoginDto(String adminId, String adminPwd) {
        this.adminId = adminId;
        this.adminPwd = adminPwd;
    }
}
