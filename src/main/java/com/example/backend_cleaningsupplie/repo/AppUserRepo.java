package com.example.backend_cleaningsupplie.repo;

import com.example.backend_cleaningsupplie.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);



}

