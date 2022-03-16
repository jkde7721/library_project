package com.example.library.repository;

import com.example.library.domain.Return;

import java.util.List;

public interface ReturnRepository {

    void save(Return returnObj);
    List<Return> findById(String userId);
}
