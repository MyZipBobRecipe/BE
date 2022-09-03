package com.example.jwtlogin.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) { this.password = password; }

    @Builder
    public Member(Long id, String email, String password, String nickname, Authority authority) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.authority = authority;
    }
}