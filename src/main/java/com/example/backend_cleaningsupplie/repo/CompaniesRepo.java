package com.example.backend_cleaningsupplie.repo;

import com.example.backend_cleaningsupplie.entities.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompaniesRepo extends JpaRepository<Companies, Integer> {

    Optional<Companies>findByCompaniesName(String companiesName);
}
