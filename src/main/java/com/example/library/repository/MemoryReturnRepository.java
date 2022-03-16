package com.example.library.repository;

import com.example.library.domain.Return;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MemoryReturnRepository implements ReturnRepository {

    private static final Map<Long, Return> returnStore = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public void save(Return returnObj) {
        returnObj.setReturnId(++sequence);
        returnStore.put(returnObj.getReturnId(), returnObj);
    }

    @Override
    public List<Return> findListByUserId(String userId) {
        return returnStore.values().stream().filter(returnObj -> returnObj.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
