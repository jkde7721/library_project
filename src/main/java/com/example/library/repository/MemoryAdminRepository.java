package com.example.library.repository;

import com.example.library.domain.Admin;

import java.util.HashMap;
import java.util.Map;

public class MemoryAdminRepository implements AdminRepository {

    private static final Map<String, Admin> adminStore = new HashMap();

    @Override
    public String save(Admin admin) {
        adminStore.put(admin.getAdminId(), admin);
        return admin.getAdminId();
    }

    @Override
    public boolean login(Admin admin) {
        Admin findAdmin = adminStore.get(admin.getAdminId());
        return (findAdmin.getAdminPwd().equals(admin.getAdminPwd()));
    }
}
