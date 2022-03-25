package com.example.library.service;

import com.example.library.domain.Admin;
import com.example.library.domain.Book;
import com.example.library.domain.Return;
import com.example.library.domain.User;
import com.example.library.dto.ReturnDto;
import com.example.library.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final BorrowRepository borrowRepository;
    private final ReturnRepository returnRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private static Long sequence = 0L;

    public void processReturn(ReturnDto returnDto) {
        Return returnObj = new Return();
        // 반납번호, 도서 번호, 관리자 번호, 이용자 번호, 반납일, 반납시간
        returnObj.setReturnId(++sequence);
        returnObj.setReturnDay(LocalDate.now());
        returnObj.setReturnTime(LocalDateTime.now());

        Book book = bookRepository.findById(returnDto.getBookId());
        returnObj.setBook(book);
        Admin admin = adminRepository.findById(returnDto.getAdminId());
        returnObj.setAdmin(admin);

        String userId = borrowRepository.delete(returnDto.getBookId()); // 대출 테이블에서 대출 정보 삭제 후, 대출한 이용자 아이디 get
        User user = userRepository.findById(userId).get(0);
        user.addReturnList(returnObj); //연관관계 편의 메서드 (내부적으로 returnObj.setUser(user) 호출)

        returnRepository.save(returnObj);
    }

    public List<Return> findReturnListByUserId(String userId) {
        return returnRepository.findById(userId);
    }
}
