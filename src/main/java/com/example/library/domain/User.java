package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(
        name = "USER_SEQ_GENERATOR",
        sequenceName = "USER_SEQ")
@NoArgsConstructor
@Getter @Setter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GENERATOR")
    @Column(name = "USER_SEQ")
    private Long userSeq;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "USER_PWD")
    private String userPwd;

    @Column(name = "USER_SHORT_PWD", length = 4)
    private String userShortPwd; // '0000'의 경우때문에 String

    private int suspendedTerm;
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
