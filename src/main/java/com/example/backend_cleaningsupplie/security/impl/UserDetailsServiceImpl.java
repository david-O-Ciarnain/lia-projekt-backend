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
    //TODO: ned something else in the text of USER_NOT_FOUND
    private final static String USER_NOT_FOUND ="user with email %s not found";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND,username)));
    }


}
