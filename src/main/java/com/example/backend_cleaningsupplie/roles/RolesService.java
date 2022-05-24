package com.example.backend_cleaningsupplie.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private RolesRepo rolesRepo;

    public String savedRoles(String name){
        List<Roles>rolesList = List.of(
               /* new Roles("ROLE_USER"),
                new Roles("ROLE_MANAGER"),
                new Roles("ROLE_ADMIN"),
                new Roles("ROLE_SUPER_ADMIN")

                */
                new Roles(name)
        );
        rolesRepo.saveAll(rolesList);
        return name;
    }


    public Roles getRole(String roleName){

        return rolesRepo.findByName(roleName);
    }
}
