package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReturnDto {

    private Long bookId;
    private String adminId;

    public ReturnDto(Long bookId, String adminId) {
        this.bookId = bookId;
        this.adminId = adminId;
    }
}
