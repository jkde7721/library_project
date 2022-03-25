package com.example.library.repository.db;

import com.example.library.domain.Admin;
import com.example.library.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@RequiredArgsConstructor
@Repository
@Primary
public class DbAdminRepository implements AdminRepository {

    private final EntityManager em;

    @Override
    public String save(Admin admin) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            em.persist(admin);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        return admin.getAdminId();
    }

    @Override
    public Admin findById(String adminId) {
        return em.find(Admin.class, adminId);
    }

    @Override
    public boolean compareByIdAndPwd(Admin admin) {
        Admin findAdmin = em.find(Admin.class, admin.getAdminId()); //오류 처리
        return (findAdmin.getAdminPwd().equals(admin.getAdminPwd()));
    }
}
