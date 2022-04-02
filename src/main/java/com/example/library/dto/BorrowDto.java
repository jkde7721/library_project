package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BorrowDto {

    private Long bookId;
    private String userId;
    private String adminId;

    public BorrowDto(Long bookId, String userId, String adminId) {
        this.bookId = bookId;
        this.userId = userId;
        this.adminId = adminId;
    }
}
