package com.example.library.repository;

import com.example.library.domain.Borrow;

import java.util.List;

public interface BorrowRepository {

    void save(Borrow borrowObj);
    List<Borrow> findListByUserId(String userId);
}
