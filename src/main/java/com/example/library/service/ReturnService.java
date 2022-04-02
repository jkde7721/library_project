package com.example.library.service;

import com.example.library.domain.Admin;
import com.example.library.domain.Book;
import com.example.library.domain.Return;
import com.example.library.domain.User;
import com.example.library.dto.ReturnDto;
import com.example.library.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReturnService {

    private final BorrowRepository borrowRepository;
    private final ReturnRepository returnRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public void processReturn(ReturnDto returnDto) {
        Return returnObj = new Return();
        // 반납번호, 도서 번호, 관리자 번호, 이용자 번호, 반납일, 반납시간
        returnObj.setReturnDay(LocalDate.now());
        returnObj.setReturnTime(LocalDateTime.now());

        Book book = bookRepository.findById(returnDto.getBookId());
        returnObj.setBook(book);
        Admin admin = adminRepository.findById(returnDto.getAdminId());
        returnObj.setAdmin(admin);

        Long userSeq = borrowRepository.delete(returnDto.getBookId()); // 대출 테이블에서 대출 정보 삭제 후, 대출한 이용자 아이디 get
        if(userSeq == -1) return;
        User user = userRepository.findBySeq(userSeq);
        user.addReturnList(returnObj); //연관관계 편의 메서드 (내부적으로 returnObj.setUser(user) 호출)

        returnRepository.save(returnObj);
    }

    public List<Return> findReturnListByUserId(String userId) {
        return returnRepository.findByUserId(userId);
    }
}
