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

    // 이용자 조회 (filtering?)
    @GetMapping("/users")
    public String findUserList(Model model) {
        // 전체 이용자 검색 로직
        return "admin/userList";
    }

    @GetMapping(value = "/users", params = "userId")
    public String findByUserId(@RequestParam String userId, Model model) {
        // 한 이용자 아이디로 검색하는 로직
        System.out.println("userId = " + userId);
        System.out.println("AdminController.findByUserId");
        return "admin/userList";
    }

    @GetMapping(value = "/users", params = "userName")
    public String findByUserName(@RequestParam String userName, Model model) {
        // 한 이용자 이름으로 검색하는 로직
        System.out.println("userName = " + userName);
        System.out.println("AdminController.findByUserName");
        return "admin/userList";
    }

    // 대출
    @GetMapping("/borrow")
    public String borrowForm() {
        return "admin/borrowForm";
    }

    @PostMapping("/borrow")
    public String processBorrow(@ModelAttribute BorrowDto borrowDto) {
        // 대출 처리 로직
        return "redirect:/security/borrow"; // 다시 대출 처리 폼으로
    }

    // 반납
    @GetMapping("/return")
    public String returnForm() {
        return "admin/returnForm";
    }

    @PostMapping("/return")
    public String processReturn(@RequestParam Long bookId) {
        // 반납 처리 로직 (반납 테이블에 추가 및 대출 테이블에서 삭제)
        return "redirect:/security/return"; // 다시 반납 처리 폼으로
    }
}
