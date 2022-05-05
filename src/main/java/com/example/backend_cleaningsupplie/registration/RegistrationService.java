package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import com.example.backend_cleaningsupplie.appuser.AppUserRole;
import com.example.backend_cleaningsupplie.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserService appUserService;

    public String register(RegistrationRequest request) {

       boolean isEmailValid = emailValidator.test(request.getEmail());

       if(!isEmailValid){
           throw new IllegalStateException("email not valid");
       }
    return appUserService.singUpAppUser(new AppUser(
            request.getFirstName(),
            request.getLastName(),
            request.getUsername(),
            request.getPassword(),
            request.getEmail(),
            request.getDateOfBirth(),
            AppUserRole.USER
    ));
    }
}
