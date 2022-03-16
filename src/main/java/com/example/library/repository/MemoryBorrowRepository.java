package com.example.library.repository;

import com.example.library.domain.Borrow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryBorrowRepository implements BorrowRepository {

    private static final Map<Long, Borrow> borrowStore = new HashMap<>();

    @Override
    public void save(Borrow borrowObj) {
        borrowStore.put(borrowObj.getBookId(), borrowObj);
    }

    @Override
    public List<Borrow> findListByUserId(String userId) {
        return borrowStore.values().stream().filter(borrowObj -> borrowObj.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
