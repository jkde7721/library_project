package com.example.library.controller;

import com.example.library.domain.Book;
import com.example.library.domain.BookKind;
import com.example.library.dto.BookSearchDto;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // 도서 전체 조회
    @GetMapping
    public String findBookList(@ModelAttribute BookSearchDto bsDto, Model model) {
        List<Book> books;
        // 처음 페이지 요청시
        if(bsDto.getBookName() == null && bsDto.getBookAuthor() == null) {
            books = bookService.findBooks();
        }
        // 폼 요청시
        else {
            books = bookService.searchBookList(bsDto.getBookName(), bsDto.getBookAuthor());
        }

        model.addAttribute("books", books);
        model.addAttribute("bsDto", bsDto);
        return "book/bookList";
    }
}
