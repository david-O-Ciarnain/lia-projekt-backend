package com.example.backend_cleaningsupplie.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token, String> {

    Optional<Token> findByToken(String token);


    @Transactional
    @Modifying
    @Query(
            "UPDATE Token c SET c.confirmAt = ?2  WHERE  c.token =?1"
    )
    int updateConfirmToken(String token, LocalDateTime confirmedAt);
}
