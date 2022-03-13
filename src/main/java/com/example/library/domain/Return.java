package com.example.library.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Entity
@NoArgsConstructor
public class Return {

    @Id
    private Long bookId;
    @Id
    private LocalDate returnDay;
    @Id
    private LocalDateTime returnTime;

    private String userId;
    private String adminId;

    // 생성자 내부에서 returnDay, returnTime 필드값을 초기화해야 하나?
    public Return(Long bookId, String userId, String adminId) {
        this.bookId = bookId;
        this.userId = userId;
        this.adminId = adminId;
    }
}
