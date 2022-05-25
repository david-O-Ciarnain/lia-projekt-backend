package com.example.backend_cleaningsupplie.appuser.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private RolesRepo rolesRepo;
    public Roles saveNewRol(Roles roles){
        if(roles == null){
            throw new IllegalStateException("no roles have been added");
        }
        if(rolesRepo.existsByName(roles)){
            throw new IllegalStateException("roles already exists ");
        }
        return rolesRepo.save(roles);
    }

    public String savedRoles(String name){
        List<Roles>rolesList = new ArrayList<>();
               /* new Roles("ROLE_USER"),
                new Roles("ROLE_MANAGER"),
                new Roles("ROLE_ADMIN"),
                new Roles("ROLE_SUPER_ADMIN")

                */
            rolesList.add(new Roles(name));

        rolesRepo.saveAll(rolesList);
        return name;

    }
    public List<Roles> getAllRolls(){
        return rolesRepo.findAll();
    }


    public Roles getRole(String roleName){

        return rolesRepo.findByName(roleName);
    }
}
