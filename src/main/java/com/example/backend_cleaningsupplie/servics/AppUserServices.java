package com.example.backend_cleaningsupplie.servics;


import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AppUserServices {

    @Autowired
    AppUserRepo appUserRepo;


    public List<AppUser> getAppUser() {
        return appUserRepo.findAll();
    }

    public AppUser findAppUserById(int id) {
        return appUserRepo.findById(id).orElseThrow();
    }

    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepo.save(appUser);
    }

    public void deleteAppUser(AppUser appUser) {
        appUserRepo.delete(appUser);
    }

    public AppUser updateAppUser(int id, AppUser changedAppUser) {
        AppUser existingAppUser = appUserRepo.findById(id).orElseThrow();

        if (changedAppUser.getUser_name() != null) {
            existingAppUser.setUser_name(changedAppUser.getUser_name());
        }
        if (changedAppUser.getPassword() != null) {
            existingAppUser.setPassword(changedAppUser.getPassword());
        }
        if (changedAppUser.getFirst_name() != null) {
            existingAppUser.setFirst_name(changedAppUser.getFirst_name());
        }
        if (changedAppUser.getLast_name() != null) {
            existingAppUser.setLast_name(changedAppUser.getLast_name());
        }
        if (changedAppUser.getMail() != null) {
            existingAppUser.setMail(changedAppUser.getMail());
        }
        if (changedAppUser.getTel_number() != null) {
            existingAppUser.setTel_number(changedAppUser.getTel_number());
        }
        if (changedAppUser.getCity() != null) {
            existingAppUser.setCity(changedAppUser.getCity());
        }

        if (changedAppUser.getStreet() != null) {
            existingAppUser.setStreet(changedAppUser.getStreet());
        }
        if (changedAppUser.getPost_number() != null) {
            existingAppUser.setPost_number(changedAppUser.getPost_number());
        }

        appUserRepo.save(existingAppUser);

        return existingAppUser;
    }


}
