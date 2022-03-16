package com.example.library.controller;

import com.example.library.dto.UserUpdateDto;
import com.example.library.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//@RestController
@Controller
@RequestMapping("/users")
public class UserController {

    // 이용자 홈페이지
    @GetMapping
    public String userPage() {
        System.out.println("UserController.userPage");
        return "user/home";
    }

    // 회원가입
    /**
     * 회원가입 완료 후, 로그인 페이지로 이동(회원가입 정상완료 메시지 띄우기)
     */
    @GetMapping("/join")
    public String joinForm() {
        System.out.println("UserController.joinForm");
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(RedirectAttributes redirectAttributes) {
        System.out.println("UserController.join");
        redirectAttributes.addAttribute("join", true);
        return "redirect:/users/login";
    }
    
    //로그인 
    @GetMapping("/login")
    public String loginForm() {
        System.out.println("UserController.loginForm");
        return "user/loginForm"; 
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto) {
        System.out.println("userLoginDto.getUserId() = " + userLoginDto.getUserId());
        System.out.println("userLoginDto.getUserLongPwd() = " + userLoginDto.getUserLongPwd());
        System.out.println("UserController.login");
        // 로그인 처리...
        return "redirect:/users"; 
    }

    // 조회
    @GetMapping("/{userId}")
    public String findById(@PathVariable String userId) {
        System.out.println("userId = " + userId);
        System.out.println("UserController.findById");
        return "user/user";
    }

    @GetMapping("/{userId}/borrow")
    public String findBorrowList(@PathVariable String userId) {
        System.out.println("userId = " + userId);
        System.out.println("UserController.findBorrowList");
        return "user/borrowList";
    }

    @GetMapping("/{userId}/return")
    public String findReturnList(@PathVariable String userId) {
        System.out.println("userId = " + userId);
        System.out.println("UserController.findReturnList");
        return "user/returnList";
    }

    // 수정
    @GetMapping("/{userId}/edit")
    public String updateForm(@PathVariable String userId, Model model) {
        System.out.println("userId = " + userId);
        System.out.println("UserController.updateForm");
        return "user/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String update(@PathVariable String userId, @ModelAttribute UserUpdateDto userDto) {
        // 이용자 정보 수정 로직
        System.out.println("userId = " + userId);
        System.out.println("UserController.update");
        return "redirect:/users/{userId}";
    }
}
