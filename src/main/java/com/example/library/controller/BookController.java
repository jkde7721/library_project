package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    // 도서 전체 조회
    @GetMapping
    public String findBookList(Model model) {
        return "book/bookList";
    }

    // 일단 bookName, author 파라미터가 모두 존재할 때 매핑
    @GetMapping(params = {"bookName", "author"})
    public String findByNameAndAuth(Model model) {
        return "book/bookList";
    }
}
