package com.example.library.controller;

import com.example.library.domain.Borrow;
import com.example.library.domain.Return;
import com.example.library.domain.User;
import com.example.library.dto.UserUpdateDto;
import com.example.library.dto.UserLoginDto;
import com.example.library.service.BorrowService;
import com.example.library.service.ReturnService;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BorrowService borrowService;
    private final ReturnService returnService;

    // 이용자 홈페이지
    @GetMapping
    public String userPage() {
        return "user/home";
    }

    // 회원가입
    /**
     * 회원가입 완료 후, 로그인 페이지로 이동(회원가입 정상완료 메시지 띄우기)
     */
    @GetMapping("/join")
    public String joinForm() {
        return "user/joinForm";
    }

    @PostMapping("/join")
    public String join(RedirectAttributes redirectAttributes, @ModelAttribute User user) {
        userService.join(user);
        redirectAttributes.addAttribute("join", true);
        return "redirect:/users/login";
    }
    
    //로그인 
    @GetMapping("/login")
    public String loginForm() {
        return "user/loginForm"; 
    }
    
    @PostMapping("/login")
    public String login(@ModelAttribute UserLoginDto userLoginDto) {
        // 로그인 처리
        userService.login(userLoginDto);
        return "redirect:/users"; 
    }

    // 조회
    @GetMapping("/{userId}")
    public String findById(@PathVariable String userId, Model model) {
        User user = userService.findListById(userId).get(0);
        model.addAttribute("user", user);
        return "user/user";
    }

    @GetMapping("/{userId}/borrow")
    public String findBorrowList(@PathVariable String userId, Model model) {
        List<Borrow> borrowList = borrowService.findBorrowListByUserId(userId);
        model.addAttribute("borrowList", borrowList);
        return "user/borrowList";
    }

    @GetMapping("/{userId}/return")
    public String findReturnList(@PathVariable String userId, Model model) {
        List<Return> returnList = returnService.findReturnListByUserId(userId);
        model.addAttribute("returnList", returnList);
        return "user/returnList";
    }

    // 수정
    @GetMapping("/{userId}/edit")
    public String updateForm(@PathVariable String userId, Model model) {
        User user = userService.findListById(userId).get(0);
        model.addAttribute("user", user);
        return "user/editForm";
    }

    @PostMapping("/{userId}/edit")
    public String update(@PathVariable String userId, @ModelAttribute UserUpdateDto userDto) {
        // 이용자 정보 수정 로직
        userService.updateUser(userId, userDto);
        return "redirect:/users/{userId}";
    }
}
