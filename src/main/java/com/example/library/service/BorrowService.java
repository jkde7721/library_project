package com.example.library.service;

import com.example.library.domain.Book;
import com.example.library.domain.Borrow;
import com.example.library.dto.BorrowDto;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowService {

    private final BorrowRepository borrowRepository;
    private final BookRepository bookRepository;

    public void processBorrow(BorrowDto borrowDto) {
        Borrow borrowObj = new Borrow();
        // 도서번호, 이용자 아이디, 관리자 아이디, 대출일, 반납예정일, 연체일수, 연기회수
        borrowObj.setBookId(borrowDto.getBookId());
        borrowObj.setUserId(borrowDto.getUserId());
        borrowObj.setAdminId(borrowDto.getAdminId());
        borrowObj.setBorrowDay(LocalDate.now());
        borrowObj.setExpecReturnDay(LocalDate.now().plusDays(14));
        borrowObj.setOverdueDay(0);
        borrowObj.setDelayTimes(0);
        Book book = bookRepository.findById(borrowDto.getBookId());
        borrowObj.setBook(book);

        borrowRepository.save(borrowObj);
    }

    public List<Borrow> findBorrowListByUserId(String userId) {
        return borrowRepository.findById(userId);
    }
}
