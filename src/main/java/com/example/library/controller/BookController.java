package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 전체 조회
    @GetMapping
    public String findBookList(Model model, @RequestParam(required = false) String bookName, @RequestParam(required = false) String bookAuthor) {
        // 일단 bookName, bookAuthor 조회 기능 제외
        List<Book> books = bookService.findBooks();
        model.addAttribute("books", books);
        return "book/bookList";
    }

    // 도서 등록
    @GetMapping("/add")
    public String addForm() {
        return "admin/addBookForm";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Book book, @ModelAttribute BookKind bookKind) {
        bookService.register(book, bookKind);
        return "redirect:/books/add";
    }

    // 도서 수정
    // 일단 제외

    // 도서 삭제
    // => 조건 체크가 조금 복잡해서 일단 구현X
}
