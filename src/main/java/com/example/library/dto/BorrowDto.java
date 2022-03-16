package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BorrowDto {

    private String userId;
    private Long bookId;
    private String adminId;

    public BorrowDto(String userId, Long bookId, String adminId) {
        this.userId = userId;
        this.bookId = bookId;
        this.adminId = adminId;
    }
}
