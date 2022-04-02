package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(
        name = "BORROW_SEQ_GENERATOR",
        sequenceName = "BORROW_SEQ")
@NoArgsConstructor
@Getter @Setter
public class Borrow {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BORROW_SEQ_GENERATOR")
    @Column(name = "BORROW_ID")
    private Long borrowId;

    @OneToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    //연관관계 주인
    @ManyToOne
    @JoinColumn(name = "USER_SEQ")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ADMIN_SEQ")
    private Admin admin;

    @Column(name = "BORROW_DAY")
    private LocalDate borrowDay;

    @Column(name = "EXPECTED_RETURN_DAY")
    private LocalDate expectedReturnDay;

    @Column(name = "OVERDUE_DAY")
    private int overdueDay;

    @Column(name = "DELAY_TIMES")
    private int delayTimes;
}
