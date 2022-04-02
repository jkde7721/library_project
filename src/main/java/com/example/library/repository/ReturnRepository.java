package com.example.library.repository;

import com.example.library.domain.Return;

import java.util.List;

public interface ReturnRepository {

    Long save(Return returnObj);
    List<Return> findByUserId(String userId);
}
