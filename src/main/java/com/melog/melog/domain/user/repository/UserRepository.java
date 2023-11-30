package com.melog.melog.domain.user.repository;

import com.melog.melog.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);


//    Optional<User> findByRefreshToken(String refreshToken);
}
