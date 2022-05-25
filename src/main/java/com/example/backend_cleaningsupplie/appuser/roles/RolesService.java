package com.example.backend_cleaningsupplie.appuser.roles;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RolesService {

    private RolesRepo rolesRepo;



    public List<Roles> getAllRolls() {
        List<Roles> preSetRoles = new ArrayList<>();

        if(preSetRoles.isEmpty()){
            preSetRoles = List.of(
                    new Roles("USER"),
                    new Roles("MANAGER"),
                    new Roles("ADMIN"),
                    new Roles("SUPER_ADMIN")

            );
            List<Roles> rolesList = new ArrayList<>(preSetRoles);
            rolesRepo.saveAll(rolesList);
        }




        return rolesRepo.findAll();
    }


}
