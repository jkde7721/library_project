package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "BOOK_KIND_SEQ_GENERATOR",
        sequenceName = "BOOK_KIND_SEQ")
@NoArgsConstructor
@Getter @Setter
@Table(name = "BOOK_KIND")
public class BookKind {
    // 도서 등록시, (도서명, 저자, 출판사, 발행년)과 모두 일치하는 튜플이 없다면
    // 도서종류 테이블에 추가함과 동시에, 도서 테이블에도 정보 추가
    // 청구기호 특정 로직에 의해 자동 생성, 등록번호는 +1, 복본의 기본값은 1

    // 만약 모두 일치하는 튜플이 도서종류 테이블에 존재한다면, 해당 청구기호로
    // 도서 테이블에 튜플 추가, 등록번호 +1, 해당 청구기호의 복본 속성 중 가장 큰 값 +1
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_KIND_SEQ_GENERATOR")
    @Column(name = "BOOK_KIND_ID")
    private Long bookKindId;

    @Column(name = "BOOK_SYMBOL")
    private String bookSymbol;

    @Column(name = "BOOK_NAME")
    private String bookName;

    @Column(name = "BOOK_AUTHOR")
    private String bookAuthor;

    @Column(name = "BOOK_PUBLISHER")
    private String bookPublisher;

    @Column(name = "BOOK_PUB_YEAR")
    private int bookPubYear;
}
