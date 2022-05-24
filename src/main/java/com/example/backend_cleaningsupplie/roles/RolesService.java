package com.example.backend_cleaningsupplie.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private RolesRepo rolesRepo;

    private void savedRoles(){
        List<Roles>rolesList = List.of(
                new Roles("ROLE_USER"),
                new Roles("ROLE_MANAGER"),
                new Roles("ROLE_ADMIN"),
                new Roles("ROLE_SUPER_ADMIN")
        );
        rolesRepo.saveAll(rolesList);
    }

    public List<Roles>getRoles(){

        savedRoles();
        return rolesRepo.findAll();
    }
    public Roles getRole(String roleName){
        savedRoles();
      Roles roles =  rolesRepo.findByName(roleName);
      return roles;
    }
}
