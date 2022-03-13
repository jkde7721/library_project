package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BorrowDto {

    private String userId;
    private Long bookId;

    public BorrowDto(String userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }
}
