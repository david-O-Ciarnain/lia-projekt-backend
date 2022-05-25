package com.example.backend_cleaningsupplie.appuser.roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepo extends JpaRepository<Roles,String> {

    Roles findByName(String roleName);
    Boolean existsByName(Roles roles);
}
