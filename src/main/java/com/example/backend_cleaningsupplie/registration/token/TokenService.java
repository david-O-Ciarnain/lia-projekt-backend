package com.example.backend_cleaningsupplie.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TokenService {

    private final TokenRepo tokenRepo;

    public void saveToken(Token token) {

        tokenRepo.save(token);
    }
}
