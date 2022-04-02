package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@SequenceGenerator(
        name = "RETURNS_SEQ_GENERATOR",
        sequenceName = "RETURNS_SEQ")
@NoArgsConstructor
@Getter @Setter
@Table(name = "RETURNS")
public class Return {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RETURNS_SEQ_GENERATOR")
    @Column(name = "RETURN_ID")
    private Long returnId; // increment

    //연관관계 주인
    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "USER_SEQ")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ADMIN_SEQ")
    private Admin admin;

    @Column(name = "RETURN_DAY")
    private LocalDate returnDay;

    @Column(name = "RETURN_TIME")
    private LocalDateTime returnTime;
}
