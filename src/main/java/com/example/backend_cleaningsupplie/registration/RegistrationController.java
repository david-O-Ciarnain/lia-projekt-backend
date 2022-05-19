package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "test/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping
    public String registerUser(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

    @GetMapping(path = "/appusers")
    public List<AppUser>getAll(String keyword){
       return registrationService.getAllAppUser(keyword);
    }
    @DeleteMapping(path = "/appusers/{name}")
    public void deleteAppUserByName(@PathVariable("name") String name){
        registrationService.deleteAppUser(name);
    }


}
