package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Borrow {

    @Id @GeneratedValue
    @Column(name = "BORROW_ID")
    private Long borrowId;

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    //연관관계 주인
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Admin admin;

    private LocalDate borrowDay;
    private LocalDate expecReturnDay;
    private int overdueDay;
    private int delayTimes;
}
