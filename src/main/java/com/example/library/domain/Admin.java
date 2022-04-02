package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "ADMIN_SEQ_GENERATOR",
        sequenceName = "ADMIN_SEQ")
@NoArgsConstructor
@Getter @Setter
public class Admin {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMIN_SEQ_GENERATOR")
    @Column(name = "ADMIN_SEQ")
    private Long adminSeq;

    @Column(name = "ADMIN_ID")
    private String adminId;

    @Column(name = "ADMIN_PWD")
    private String adminPwd;
}
