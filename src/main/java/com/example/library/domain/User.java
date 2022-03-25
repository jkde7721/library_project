package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userId;

    private String userLongPwd;
    private char[] userShortPwd;
    private int suspenTerm;
    private String userTel;
    private String userName;

    //양방향 연관관계
    //대출내역
    @OneToMany(mappedBy = "user")
    private List<Borrow> borrows = new ArrayList<>();

    //반납내역
    @OneToMany(mappedBy = "user")
    private List<Return> returns = new ArrayList<>();

    //연관관계 편의 메서드
    public void addBorrowList(Borrow borrowObj) {
        borrows.add(borrowObj);
        borrowObj.setUser(this);
    }

    public void addReturnList(Return returnObj) {
        returns.add(returnObj);
        returnObj.setUser(this);
    }
}
