package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Entity
@NoArgsConstructor
@Getter @Setter
public class Return {

    @Id
    private Long returnId; // increment

    private Long bookId;
    private LocalDate returnDay;
    private LocalDateTime returnTime;

    private String userId;
    private String adminId;

    private Book book;

    // 생성자 내부에서 returnDay, returnTime 필드값을 초기화해야 하나?
    public Return(Long bookId, String userId, String adminId) {
        this.bookId = bookId;
        this.userId = userId;
        this.adminId = adminId;
    }
}
