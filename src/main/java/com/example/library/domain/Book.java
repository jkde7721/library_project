package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "BOOK_SEQ_GENERATOR",
        sequenceName = "BOOK_SEQ")
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_SEQ_GENERATOR")
    @Column(name = "BOOK_ID")
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "BOOK_KIND_ID")
    private BookKind bookKind;

    @Column(name = "BOOK_COPY")
    private int bookCopy; // DB 쿼리를 통해 값 설정하는 비즈니스 로직 필요
}
