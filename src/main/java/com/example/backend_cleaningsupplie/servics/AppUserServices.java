package com.example.backend_cleaningsupplie.servics;


import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServices {

    @Autowired
    AppUserRepo appUserRepo;

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
            .map(user ->{
            user.setUser_name(changedAppUser.getUser_name());
            user.setPassword(changedAppUser.getPassword());
            user.setFirst_name(changedAppUser.getFirst_name());
            user.setLast_name(changedAppUser.getLast_name());
            user.setMail(changedAppUser.getMail());
            user.setDate_of_birth(changedAppUser.getDate_of_birth());

            return appUserRepo.save(user);
            })
            .orElseGet(() -> {
                changedAppUser.setId(id);
                return appUserRepo.save(changedAppUser);
            });

   
    }
}
