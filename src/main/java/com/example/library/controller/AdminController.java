package com.example.library.controller;

import com.example.library.domain.Admin;
import com.example.library.domain.User;
import com.example.library.dto.BorrowDto;
import com.example.library.dto.ReturnDto;
import com.example.library.service.AdminService;
import com.example.library.service.BorrowService;
import com.example.library.service.ReturnService;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/security")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final BorrowService borrowService;
    private final ReturnService returnService;

    // 홈
    @GetMapping
    public String adminPage() {
        return "admin/home";
    }

    // 회원가입
    @GetMapping("/join")
    public String joinForm() {
        return "admin/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute Admin admin) {
        // 회원가입 처리 로직
        adminService.join(admin);
        return "redirect:/security";
    }

    // 로그인
    @GetMapping("/login")
    public String loginForm() {
        return "admin/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Admin admin) {
        // 로그인 처리 로직
        boolean isLogin = adminService.login(admin); // 로그인 성공여부 파라미터로 전달?
        return "redirect:/security";
    }

    // 이용자 조회 (filtering?) => model에 List 객체 실어나름
    @GetMapping("/users")
    public String findUserList(Model model, @RequestParam(required = false) String userId, @RequestParam(required = false) String userName) {
        // 전체 이용자 검색 로직
        List<User> users;
        if(userId != null) {
            users = userService.findListById(userId);
        } else if(userName != null) {
            users = userService.findListByName(userName);
        } else {
            users = userService.findUsers();
        }

        model.addAttribute("users", users);
        return "admin/userList";
    }

    // 대출, 반납 처리 완료 자바스크립트 메시지 띄우기
    // 대출
    @GetMapping("/borrow")
    public String borrowForm() {
        return "admin/borrowForm";
    }

    @PostMapping("/borrow")
    public String processBorrow(@ModelAttribute BorrowDto borrowDto) {
        // 대출 처리 로직
        borrowService.processBorrow(borrowDto);
        return "redirect:/security/borrow"; // 다시 대출 처리 폼으로
    }

    // 반납
    @GetMapping("/return")
    public String returnForm() {
        return "admin/returnForm";
    }

    @PostMapping("/return")
    public String processReturn(@ModelAttribute ReturnDto returnDto) {
        // 반납 처리 로직 (반납 테이블에 추가 및 대출 테이블에서 삭제)
        returnService.processReturn(returnDto);
        return "redirect:/security/return"; // 다시 반납 처리 폼으로
    }
}
