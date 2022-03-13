package com.example.library.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

//@Entity
@NoArgsConstructor
public class Borrow {

    @Id
    private Long bookId;
    private String userId;
    private String adminId;
    private Date borrowDay;
    private Date expecReturnDay;
    private int overdueDay;
    private int delayTimes;

    // 생성자 내부에서 borrowDay, expecReturnDay 필드값을 초기화해야 하나?
    public Borrow(Long bookId, String userId, String adminId) {
        this.bookId = bookId;
        this.userId = userId;
        this.adminId = adminId;
        this.overdueDay = 0;
        this.delayTimes = 0;
    }
}
