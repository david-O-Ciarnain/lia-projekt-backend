package com.example.backend_cleaningsupplie.security;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfTokenController {

    @RequestMapping("/csrf")
    public CsrfToken csrf(CsrfToken token){
        return token;
    }

}
