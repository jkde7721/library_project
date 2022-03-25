package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id
    @Column(name = "BOOK_ID")
    private Long bookId;

    @ManyToOne
    @JoinColumn(name = "BOOK_SYMBOL")
    private BookKind bookKind;

    private int bookCopy; // DB 쿼리를 통해 값 설정하는 비즈니스 로직 필요
}
