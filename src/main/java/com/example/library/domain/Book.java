package com.example.library.domain;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
@NoArgsConstructor
public class Book {

    @Id
    private Long bookId;
    private String bookSymbol;
    private int bookCopy; // DB 쿼리를 통해 값 설정하는 비즈니스 로직 필요

    public Book(String bookSymbol) {
        this.bookSymbol = bookSymbol;
    }
}
