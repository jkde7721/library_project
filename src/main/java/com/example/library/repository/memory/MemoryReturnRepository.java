package com.example.library.repository.memory;

import com.example.library.domain.Return;
import com.example.library.repository.ReturnRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MemoryReturnRepository implements ReturnRepository {

    private static final Map<Long, Return> returnStore = new HashMap<>();

    @Override
    public void save(Return returnObj) {
        returnStore.put(returnObj.getReturnId(), returnObj);
    }

    //양방향 연관관계 매핑으로 의미X
    @Override
    public List<Return> findById(String userId) {
        return returnStore.values().stream()
                .filter(returnObj -> returnObj.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }
}