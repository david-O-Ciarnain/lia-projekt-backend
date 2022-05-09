package com.example.backend_cleaningsupplie.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepo tokenRepo;

    public void saveToken(Token token) {

        tokenRepo.save(token);
    }

    public Optional<Token>getToken(String token){
        return tokenRepo.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return tokenRepo.updateConfirmToken(
                token, LocalDateTime.now()
        );
    }
}
