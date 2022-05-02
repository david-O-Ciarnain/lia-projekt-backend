package com.example.backend_cleaningsupplie.config;

import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.entities.Companies;
import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import com.example.backend_cleaningsupplie.repo.CompaniesRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {

    @Bean
    CommandLineRunner commandLineRunner(CompaniesRepo companiesRepo, AppUserRepo appUserRepo){

        return args -> {

            Companies companies = new Companies(
              "hej","12345","3132","1235"
            );
            AppUser appUser = new AppUser("")
        }
    }
}
