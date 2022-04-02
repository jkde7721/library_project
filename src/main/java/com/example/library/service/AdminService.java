package com.example.library.service;

import com.example.library.domain.Admin;
import com.example.library.dto.AdminLoginDto;
import com.example.library.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {

    private final AdminRepository adminRepository;

    @Transactional
    public Long join(Admin admin) {
        // 중복 체크 로직
        return adminRepository.save(admin);
    }

    public boolean login(AdminLoginDto adminLoginDto) {
        return adminRepository.compareByIdAndPwd(adminLoginDto);
    }
}
