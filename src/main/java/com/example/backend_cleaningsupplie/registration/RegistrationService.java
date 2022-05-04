package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import com.example.backend_cleaningsupplie.appuser.AppUserRole;
import com.example.backend_cleaningsupplie.appuser.AppUserService;
import com.example.backend_cleaningsupplie.registration.token.ConfirmToken;
import com.example.backend_cleaningsupplie.registration.token.ConfirmTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private MailValidator mailValidator;

    private AppUserService appUserService;
    private ConfirmTokenService confirmTokenService;

    public String register(RegistrationRequest request) {

        if (!mailValidator.test(request.getMail())) {
            throw new IllegalStateException("email not valid");
        }
        return appUserService.signUpAppUser(
                new AppUser(
                        request.getUserName(),
                        request.getPassword(),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getMail(),
                        request.getDateOfBirth(),
                        AppUserRole.USER_ROLE
                )
        );

    }
    @Transactional
    public String confirmToken(String token){
        ConfirmToken confirmToken = confirmTokenService.getToken(token).orElseThrow(() -> new IllegalStateException("token not found"));

        if(confirmToken.getConfirmedAt() !=null){
            throw  new IllegalStateException("mail already confirmed");
        }
        LocalDateTime expiredAt = confirmToken.getExpiredAt();
        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("token expired");
        }
        confirmTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmToken.getAppUser().getMail()
        );
        return "confirmed";
    }
}
