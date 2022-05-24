package com.example.backend_cleaningsupplie.appuser;


import com.example.backend_cleaningsupplie.registration.token.Token;
import com.example.backend_cleaningsupplie.registration.token.TokenService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class AppUserService implements UserDetailsService {

    private final AppUserRepo appUserRepo;

    private final TokenService tokenService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    private final static String USER_NOT_FOUND = "user with username @s not found";

    public List<AppUser> getAllAppUsers(String keyword) {

        if (keyword == null || keyword.isEmpty()) {
            return appUserRepo.findAll();
        }
        return appUserRepo.search(keyword);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));

    }

    public String singUpAppUser(AppUser appUser) {
        boolean userExists = appUserRepo.existsByFirstName(appUser.getUsername());
        boolean emailExists = appUserRepo.findByEmail(appUser.getEmail()).isPresent();

        if (userExists && emailExists) {
            throw new IllegalStateException("User or email is already taken");
        }
        String encoded = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encoded);

        appUserRepo.save(appUser);

        String tokenUUID = UUID.randomUUID().toString();
        Token token = new Token(
                tokenUUID,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(10),
                appUser
        );
        tokenService.saveToken(token);

        return tokenUUID;
    }

    public List<AppUser> getAppUsers(String keyword) {

        if (keyword == null || keyword.isEmpty()) {
            return appUserRepo.findAll();
        }
        return appUserRepo.search(keyword);
    }


    public void deleteAppUser(String firstName) {
        boolean exists = appUserRepo.existsByFirstName(firstName);
        if (!exists) {
            throw new IllegalStateException("user with first name " + firstName + " do not exist");
        }
        appUserRepo.deleteByFirstName(firstName);
    }


    public int enableAppUser(String username) {
        return appUserRepo.enableAppUser(username);
    }


}
