package com.example.backend_cleaningsupplie.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmTokenService {

    private final ConfirmTokenRepo confirmTokenRepo;

    public void saveConfirmToken(ConfirmToken token){
        confirmTokenRepo.save(token);
    }
    public Optional<ConfirmToken>getToken(String token){
        return confirmTokenRepo.findByToken(token);
    }
    public int setConfirmedAt(String token){
        return confirmTokenRepo.updateConfirmedAt(token, LocalDateTime.now());
    }
}
