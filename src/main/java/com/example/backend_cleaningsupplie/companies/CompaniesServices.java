package com.example.backend_cleaningsupplie.companies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesServices {

    @Autowired
    CompaniesRepo companiesRepo;

    public List<Companies> findAllCompanies() {
        return companiesRepo.findAll();
    }
    public Companies findCompaniesById(int id) {

       checkIfIdIsValid(id);
        return companiesRepo.findById(id).orElseThrow();
    }

    public void saveCompanies(Companies companies) {
        Optional<Companies> companiesByName = companiesRepo.findByCompaniesName(companies.getCompaniesName());

        if(companiesByName.isPresent()){
            throw new IllegalStateException("Company already exists");
        }
        companiesRepo.save(companies);
    }

    public void deleteCompaniesById(int id) {

       checkIfIdIsValid(id);
        companiesRepo.deleteById(id);
    }
    public void updateCompany(int id,Companies changedCompany){


        companiesRepo.findById(id)
                .map(companies -> {
                    companies.setCompaniesName(changedCompany.getCompaniesName());
                    companies.setCompaniesEmail(changedCompany.getCompaniesEmail());
                    companies.setCompaniesPhoneNumber(changedCompany.getCompaniesPhoneNumber());
                    companies.setCompaniesAdress(changedCompany.getCompaniesAdress());

                    return companiesRepo.save(companies);
                })
                .orElseGet(()->{
                    changedCompany.setId(id);
                    return companiesRepo.save(changedCompany);
                });
    }

    public void checkIfIdIsValid(int id){
        boolean exists = companiesRepo.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Company with id" + id + " do not exist");
        }
    }

}
