package com.example.library.repository.memory;

import com.example.library.domain.Borrow;
import com.example.library.repository.BorrowRepository;
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
        borrowStore.put(borrowObj.getBook().getBookId(), borrowObj);
    }

    //양방향 연관관계 매핑으로 의미X
    @Override
    public List<Borrow> findById(String userId) {
        return borrowStore.values().stream()
                .filter(borrowObj -> borrowObj.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public String delete(Long bookId) {
        String userId = borrowStore.get(bookId).getUser().getUserId(); // 대출한 이용자 번호 get
        borrowStore.remove(bookId); // 튜플 삭제
        return userId;
    }
}
