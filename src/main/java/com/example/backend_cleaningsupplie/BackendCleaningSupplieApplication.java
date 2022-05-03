package com.example.backend_cleaningsupplie;

import com.example.backend_cleaningsupplie.entities.AppUser;
import com.example.backend_cleaningsupplie.entities.Companies;
import com.example.backend_cleaningsupplie.repo.AppUserRepo;
import com.example.backend_cleaningsupplie.repo.CompaniesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class BackendCleaningSupplieApplication {

    @Autowired
    AppUserRepo appUserRepo;

    @Autowired
    CompaniesRepo companiesRepo;

    public static void main(String[] args) {
        SpringApplication.run(BackendCleaningSupplieApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CompaniesRepo companiesRepo, AppUserRepo appUserRepo){

        return args -> {

            Companies companies = new Companies(
                    "hej","12345","3132","1235"
            );
            AppUser appUser = new AppUser("sad",",thrth","dsf","jkl",1231,"qweqwe", LocalDate.of(2000, Month.FEBRUARY,28));

            companiesRepo.save(companies);
            appUserRepo.save(appUser);
        };

    }

}
