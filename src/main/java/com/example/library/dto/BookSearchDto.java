package com.example.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BookSearchDto {

    private String bookName;
    private String bookAuthor;

    public BookSearchDto(String bookName, String bookAuthor) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
    }
}
