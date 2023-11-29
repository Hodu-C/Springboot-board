package com.melog.melog.domain.user;

import com.melog.melog.domain.BaseTimeEntity;
import com.melog.melog.domain.user.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Table(name = "users")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeEntity implements Serializable {

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

    private LocalDateTime lastLogin;

    @Enumerated(EnumType.STRING)
    private Role role;

//    @OneToMany
//    @JoinColumn(name = "board_id")
//    private Board board;

    // 생성자, getter, setter 등 생략

//    public void encodePassword(PasswordEncoder passwordEncoder) {
//        this.password = passwordEncoder.encode(password);
//    }
}