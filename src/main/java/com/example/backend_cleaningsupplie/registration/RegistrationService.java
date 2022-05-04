package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.servics.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private MailValidator mailValidator;

    private AppUserServices appUserServices;

    public String register(RegistrationRequest request){

        if(!mailValidator.test(request.getMail())){
            throw new IllegalStateException("email not valid");
        }

        return "registration of mail is working";
    }
}
