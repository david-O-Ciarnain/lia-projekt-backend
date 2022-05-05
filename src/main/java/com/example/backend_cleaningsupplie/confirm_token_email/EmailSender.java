package com.example.backend_cleaningsupplie.confirm_token_email;

public interface EmailSender {

    void send(String to, String email);
}
