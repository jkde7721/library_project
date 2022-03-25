package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Return {

    @Id @GeneratedValue
    @Column(name = "RETURN_ID")
    private Long returnId; // increment

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    //연관관계 주인
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ADMIN_ID")
    private Admin admin;

    private LocalDate returnDay;
    private LocalDateTime returnTime;
}
