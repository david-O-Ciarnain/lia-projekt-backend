package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import com.example.backend_cleaningsupplie.appuser.AppUserService;
import com.example.backend_cleaningsupplie.appuser.roles.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "test/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;
    private final AppUserService appUserService;


    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping(path = "/appusers")
    public List<AppUser> getAll(String keyword) {
        return registrationService.getAllAppUser(keyword);
    }

    @DeleteMapping(path = "/appusers/{name}")
    public void deleteAppUserByName(@PathVariable("name") String name) {

        registrationService.deleteAppUser(name);
    }

    @GetMapping(path = "roles/get")
    public List<Roles> getAllRoles() {

        return registrationService.getRoles();
    }



    @PostMapping(path = "roles/addroletouser")
    public ResponseEntity<?> roleToUser(@RequestBody RoleRequest request) {

        appUserService.addRoleToUser(request.getUsername(), request.getName());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleRequest {

    private String username;
    private String name;
}