package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
@Getter @Setter
public class Book {

    @Id
    private Long bookId;
    private String bookSymbol;
    private int bookCopy; // DB 쿼리를 통해 값 설정하는 비즈니스 로직 필요

    // 외래키?
    private BookKind bookKind;

    public Book(String bookSymbol) {
        this.bookSymbol = bookSymbol;
    }
}
