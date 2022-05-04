package com.example.backend_cleaningsupplie.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with username %s not found";

    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,username)));
    }
    public String signUpAppUser(AppUser appUser){

        if(appUserRepo.findByUsername(appUser.getUsername()).isPresent()){
            throw new IllegalStateException("Username already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.password);
        appUser.setPassword(encodedPassword);

        appUserRepo.save(appUser);

        return "it works";
    }

    public int enableAppUser(String mail) {
        return appUserRepo.enableAppUser(mail);
    }
}
