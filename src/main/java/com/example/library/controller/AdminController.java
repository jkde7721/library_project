package com.example.library.controller;

import com.example.library.domain.Admin;
import com.example.library.dto.BorrowDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/security")
public class AdminController {

    // 홈
    @GetMapping
    public String adminPage() {
        System.out.println("AdminController.adminPage");
        return "admin/home";
    }

    // 회원가입
    @GetMapping("/join")
    public String joinForm() {
        System.out.println("AdminController.joinForm");
        return "admin/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Admin admin) {
        // 회원가입 처리 로직
        System.out.println("admin.getAdminId() = " + admin.getAdminId());
        System.out.println("admin.getAdminPwd() = " + admin.getAdminPwd());
        System.out.println("AdminController.join");
        return "redirect:/security";
    }

    // 로그인
    @GetMapping("/login")
    public String loginForm() {
        System.out.println("AdminController.loginForm");
        return "admin/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Admin admin) {
        // 로그인 처리 로직
        System.out.println("admin.getAdminId() = " + admin.getAdminId());
        System.out.println("admin.getAdminPwd() = " + admin.getAdminPwd());
        System.out.println("AdminController.login");
        return "redirect:/security";
    }

    // 이용자 조회 (filtering?) => model에 List 객체 실어나름
    @GetMapping("/users")
    public String findUserList(Model model, @RequestParam(required = false) String userId, @RequestParam(required = false) String userName) {
        // 전체 이용자 검색 로직
        System.out.println("userId = " + userId);
        System.out.println("userName = " + userName);
        System.out.println("AdminController.findUserList");
        return "admin/userList";
    }

    // 대출, 반납 처리 완료 자바스크립트 메시지 띄우기
    // 대출
    @GetMapping("/borrow")
    public String borrowForm() {
        System.out.println("AdminController.borrowForm");
        return "admin/borrowForm";
    }

    @PostMapping("/borrow")
    public String processBorrow(@ModelAttribute BorrowDto borrowDto) {
        // 대출 처리 로직
        System.out.println("borrowDto.getUserId() = " + borrowDto.getUserId());
        System.out.println("borrowDto.getBookId() = " + borrowDto.getBookId());
        System.out.println("AdminController.processBorrow");
        return "redirect:/security/borrow"; // 다시 대출 처리 폼으로
    }

    // 반납
    @GetMapping("/return")
    public String returnForm() {
        System.out.println("AdminController.returnForm");
        return "admin/returnForm";
    }

    @PostMapping("/return")
    public String processReturn(@RequestParam Long bookId) {
        // 반납 처리 로직 (반납 테이블에 추가 및 대출 테이블에서 삭제)
        System.out.println("bookId = " + bookId);
        System.out.println("AdminController.processReturn");
        return "redirect:/security/return"; // 다시 반납 처리 폼으로
    }
}
