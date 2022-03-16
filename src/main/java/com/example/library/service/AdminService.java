package com.example.library.service;

import com.example.library.domain.Admin;
import com.example.library.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    /**
     * String save(Admin admin);
     *     boolean login(Admin admin);
     */

    public String join(Admin admin) {
        // 중복 체크 로직
        adminRepository.save(admin);
        return admin.getAdminId();
    }

    public boolean login(Admin admin) {
        return adminRepository.compareByIdAndPwd(admin);
    }
}
