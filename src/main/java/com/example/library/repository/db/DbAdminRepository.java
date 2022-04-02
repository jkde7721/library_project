package com.example.library.repository.db;

import com.example.library.domain.Admin;
import com.example.library.dto.AdminLoginDto;
import com.example.library.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class DbAdminRepository implements AdminRepository {

    private final EntityManager em;

    @Override
    public Long save(Admin admin) {
        em.persist(admin);
        return admin.getAdminSeq();
    }

    @Override
    public Admin findById(String adminId) {
        try {
            Admin findAdmin = em.createQuery("select a from Admin a where a.adminId = :adminId", Admin.class)
                    .setParameter("adminId", adminId)
                    .getSingleResult();
            return findAdmin;
        } catch(NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean compareByIdAndPwd(AdminLoginDto adminLoginDto) {
        List<Admin> resultList = em.createQuery("select a from Admin a where a.adminId = :adminId and a.adminPwd = :adminPwd", Admin.class)
                .setParameter("adminId", adminLoginDto.getAdminId())
                .setParameter("adminPwd", adminLoginDto.getAdminPwd())
                .getResultList();
        if(resultList.size() == 0) return false;
        return true;
    }
}
