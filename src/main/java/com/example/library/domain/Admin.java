package com.example.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Admin {

    @Id
    @Column(name = "ADMIN_ID")
    private String adminId;

    private String adminPwd;
}
