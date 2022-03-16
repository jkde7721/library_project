package com.example.library.repository;

import com.example.library.domain.Borrow;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryBorrowRepository implements BorrowRepository {

    private static final Map<Long, Borrow> borrowStore = new HashMap<>();

    @Override
    public void save(Borrow borrowObj) {
        borrowStore.put(borrowObj.getBookId(), borrowObj);
    }

    @Override
    public List<Borrow> findById(String userId) {
        return borrowStore.values().stream().filter(borrowObj -> borrowObj.getUserId().equals(userId)).collect(Collectors.toList());
    }

    @Override
    public String delete(Long bookId) {
        String userId = borrowStore.get(bookId).getUserId(); // 대출한 이용자 번호 get
        borrowStore.remove(bookId); // 튜플 삭제
        return userId;
    }
}
