package com.example.backend_cleaningsupplie.contoller;

import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.servics.AppUserServices;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//  @Controllere
@RestController
@RequestMapping("/rest")
public class AppUserController {
    AppUserServices appUser;

    public AppUserController(AppUserServices appUser) {
        this.appUser = appUser;
    }

    @GetMapping("appuser/{id}")
    public AppUser getUserById(@PathVariable("id") int id) {

        return appUser.findAppUserById(id);
    }

    @GetMapping()
    public List<AppUser> findAllAppUsers() {
        return appUser.findAllAppUsers();
    }

    /*
    @PostMapping(path = "/start", consumes = "application/json", produces = "application/json")
    public AppUser saveAppUser(AppUser user) {

        return appUser.saveAppUser(user);
    }
    */
    @PostMapping("/appuser")
    public AppUser newAppUser(@RequestBody AppUser newAppUser) {
        return appUser.saveAppUser(newAppUser);
    }

    @DeleteMapping("/appuser/{id}")
    public void deleteAppUser(@PathVariable("id") int id) {
        appUser.deleteAppUserById(id);
    }

    @PutMapping("/appuser/{id}")
    public AppUser updateAppUser(@PathVariable("id") int id, AppUser changedAppUser) {

        return appUser.updateAppUser(id,changedAppUser);
    }
}



