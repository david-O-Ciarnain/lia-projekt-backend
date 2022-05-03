package com.example.backend_cleaningsupplie.servics;


import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserServices {


    private final AppUserRepo appUserRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    // basic crud functionality
    public List<AppUser> findAllAppUsers() {
        return appUserRepo.findAll();
    }

    public AppUser findAppUserById(int id) {
        return appUserRepo.findById(id).orElseThrow();
    }

    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public void deleteAppUserById(int id) {
        appUserRepo.deleteById(id);
    }

    public AppUser updateAppUser(int id, AppUser changedAppUser) {

        return appUserRepo.findById(id)
                .map(user -> {
                    user.setUserName(changedAppUser.getUserName());
                    user.setPassword(changedAppUser.getPassword());
                    user.setFirstName(changedAppUser.getFirstName());
                    user.setLastName(changedAppUser.getLastName());
                    user.setMail(changedAppUser.getMail());
                    user.setDateOfBirth(changedAppUser.getDateOfBirth());

                    return appUserRepo.save(user);
                })
                .orElseGet(() -> {
                    changedAppUser.setId(id);
                    return appUserRepo.save(changedAppUser);
                });
    }


    //registration functionality
    public String signUpAppUser(AppUser appUser) {
        boolean userExists = appUserRepo.findByMail(appUser.getMail()).isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken!! try something differens");
        }

        String encodePassword = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodePassword);

        appUserRepo.save(appUser);

        return "this works or does it?";

    }


}
