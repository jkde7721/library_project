package com.example.library.repository;

import com.example.library.domain.Borrow;

import java.util.List;

public interface BorrowRepository {

    Long save(Borrow borrowObj);
    List<Borrow> findByUserId(String userId);
    Long delete(Long bookId); //userSeq 반환
}
