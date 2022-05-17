package com.example.backend_cleaningsupplie.email;

import com.example.backend_cleaningsupplie.registration.RegistrationRequest;
import com.example.backend_cleaningsupplie.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/sendmail/send")
@AllArgsConstructor
public class MailController {
    private final MailController mailController;


    @PostMapping
    public String send(String to, String email){
        return "";
    }

    @GetMapping(path = "/toall")
    public String send(List<String> allUserMail, String subject, String text){
        return "";
    }

}

