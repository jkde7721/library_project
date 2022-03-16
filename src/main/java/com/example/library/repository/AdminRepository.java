package com.example.library.repository;

import com.example.library.domain.Admin;

public interface AdminRepository {

    String save(Admin admin);
    boolean login(Admin admin);
}
