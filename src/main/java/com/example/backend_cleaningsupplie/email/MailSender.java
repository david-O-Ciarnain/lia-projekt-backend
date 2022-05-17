package com.example.backend_cleaningsupplie.email;

import java.util.List;

public interface MailSender {
    void send(List<String> allUserMail, String subject, String text);
}
