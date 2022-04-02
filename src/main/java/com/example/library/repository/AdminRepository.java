package com.example.library.repository;

import com.example.library.domain.Admin;
import com.example.library.dto.AdminLoginDto;

public interface AdminRepository {

    Long save(Admin admin); //adminSeq 반환
    Admin findById(String adminId);
    boolean compareByIdAndPwd(AdminLoginDto adminLoginDto); //로그인 용
}
