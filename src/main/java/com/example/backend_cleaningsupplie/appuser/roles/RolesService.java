package com.example.backend_cleaningsupplie.appuser.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private RolesRepo rolesRepo;

    public String savedRoles(String name){
        List<Roles>preSetRoles = List.of(
               new Roles("USER"),
               new Roles("MANAGER"),
                       new Roles("ADMIN"),
              new Roles("SUPER_ADMIN")
       );
        if(name == null){
            throw new IllegalStateException("no roles have been added");
        }
        if(rolesRepo.existsByName(name)){
            throw new IllegalStateException("roles already exists ");
        }
        List<Roles> rolesList = new ArrayList<>(preSetRoles);
            rolesList.add(new Roles(name));

        rolesRepo.saveAll(rolesList);
        return name;

    }
    public List<Roles> getAllRolls(){
        return rolesRepo.findAll();
    }



}
