package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/books")
public class BookController {

    // 도서 전체 조회
    @GetMapping
    public String findBookList(Model model, @RequestParam(required = false) String bookName, @RequestParam(required = false) String bookAuthor) {
        System.out.println("bookName = " + bookName);
        System.out.println("bookAuthor = " + bookAuthor);
        System.out.println("BookController.findBookList");
        return "book/bookList";
    }
}
