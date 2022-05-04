package com.example.backend_cleaningsupplie.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmTokenRepo extends JpaRepository<ConfirmToken, Integer> {


    Optional<ConfirmToken> findByToken(String token);
    @Modifying
    @Query("UPDATE ConfirmToken c SET c.confirmedAt =?2 WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
