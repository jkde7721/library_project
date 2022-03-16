package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.Return;
import com.example.library.dto.ReturnDto;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import com.example.library.repository.ReturnRepository;
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
    private static Long sequence = 0L;

    /**
     * void save(Return returnObj);
     *     List<Return> findListByUserId(String userId);
     */

    public void processReturn(ReturnDto returnDto) {
        Return returnObj = new Return();
        // 반납번호, 도서 번호, 관리자 번호, 이용자 번호, 반납일, 반납시간
        String userId = borrowRepository.delete(returnDto.getBookId()); // 대출 테이블에서 대출 정보 삭제 후, 대출한 이용자 아이디 get
        returnObj.setReturnId(++sequence);
        returnObj.setBookId(returnDto.getBookId());
        returnObj.setUserId(userId);
        returnObj.setAdminId(returnDto.getAdminId());
        returnObj.setReturnDay(LocalDate.now());
        returnObj.setReturnTime(LocalDateTime.now());
        Book book = bookRepository.findById(returnDto.getBookId());
        returnObj.setBook(book);

        returnRepository.save(returnObj);
    }

    public List<Return> findReturnListByUserId(String userId) {
        return returnRepository.findById(userId);
    }
}
