package com.example.backend_cleaningsupplie.repo;

import com.example.backend_cleaningsupplie.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
}

