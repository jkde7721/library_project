package com.example.library.repository.memory;

import com.example.library.domain.Admin;
import com.example.library.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemoryAdminRepository implements AdminRepository {

    private static final Map<String, Admin> adminStore = new HashMap();

    @Override
    public String save(Admin admin) {
        adminStore.put(admin.getAdminId(), admin);
        return admin.getAdminId();
    }

    @Override
    public Admin findById(String adminId) {
        return adminStore.get(adminId);
    }

    @Override
    public boolean compareByIdAndPwd(Admin admin) {
        Admin findAdmin = adminStore.get(admin.getAdminId());
        return (findAdmin.getAdminPwd().equals(admin.getAdminPwd()));
    }
}
