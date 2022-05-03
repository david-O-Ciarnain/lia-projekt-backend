package com.example.backend_cleaningsupplie.security.impl;

import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import com.example.backend_cleaningsupplie.servics.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    AppUserRepo appUserRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    private final static String MAIL_NOT_FOUND ="user with email %s not found";
    //check for if user exist or is a valid username.
    // don't know what should be username but using mail for the moment
    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        return appUserRepo.findByMail(mail).orElseThrow(() -> new UsernameNotFoundException(String.format(MAIL_NOT_FOUND,mail)));
    }


}
