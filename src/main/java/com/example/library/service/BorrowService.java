package com.example.library.service;

import com.example.library.domain.Admin;
import com.example.library.domain.Book;
import com.example.library.domain.Borrow;
import com.example.library.domain.User;
import com.example.library.dto.BorrowDto;
import com.example.library.repository.AdminRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public void processBorrow(BorrowDto borrowDto) {
        Borrow borrowObj = new Borrow();
        // 도서번호, 이용자 아이디, 관리자 아이디, 대출일, 반납예정일, 연체일수, 연기회수
        borrowObj.setBorrowDay(LocalDate.now());
        borrowObj.setExpectedReturnDay(LocalDate.now().plusDays(14));
        borrowObj.setOverdueDay(0);
        borrowObj.setDelayTimes(0);

        Book book = bookRepository.findById(borrowDto.getBookId());
        borrowObj.setBook(book);
        Admin admin = adminRepository.findById(borrowDto.getAdminId());
        borrowObj.setAdmin(admin);

        User user = userRepository.findById(borrowDto.getUserId()).get(0);
        user.addBorrowList(borrowObj); //연관관계 편의 메서드 (내부적으로 borrowObj.setUser(user) 호출)

        borrowRepository.save(borrowObj);
    }

    public List<Borrow> findBorrowListByUserId(String userId) {
        return borrowRepository.findByUserId(userId);
    }
}
