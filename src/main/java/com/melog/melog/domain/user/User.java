package com.melog.melog.domain.user;

import com.melog.melog.domain.BaseTimeEntity;
import com.melog.melog.domain.user.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
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

    @Enumerated(EnumType.STRING)
    private Role role;
}