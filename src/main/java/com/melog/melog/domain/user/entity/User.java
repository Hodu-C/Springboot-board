package com.melog.melog.domain.user.entity;

import com.melog.melog.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String email; //아이디로 활용

    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateName(String name) {
        this.name = name;
    }
    public void updateAge(Integer age) {
        this.age = age;
    }
}