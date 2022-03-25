package com.example.library.repository;

import com.example.library.domain.Admin;

public interface AdminRepository {

    String save(Admin admin);
    Admin findById(String adminId);
    boolean compareByIdAndPwd(Admin admin);
}
