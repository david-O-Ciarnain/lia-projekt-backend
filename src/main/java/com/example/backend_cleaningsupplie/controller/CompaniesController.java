package com.example.backend_cleaningsupplie.controller;

import com.example.backend_cleaningsupplie.entities.Companies;
import com.example.backend_cleaningsupplie.servics.CompaniesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "companies")
public class CompaniesController {

    @Autowired
    CompaniesServices companiesServices;

    @GetMapping
    public List<Companies> findAllCompanies(){
        return companiesServices.findAllCompanies();
    }
    @GetMapping(path = "{id}")
    public Companies findCompaniesById(@PathVariable("id")int id){
        return companiesServices.findCompaniesById(id);
    }
    @PostMapping
    public void saveCompany(@RequestBody Companies companies){
        companiesServices.saveCompanies(companies);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCompanyById(@PathVariable("id")int id){
        companiesServices.deleteCompaniesById(id);
    }
    @PutMapping(path = "{id}")
    public void updateCompanies(@PathVariable("id")int id, Companies changedCompanies){
        companiesServices.updateCompany(id,changedCompanies);
    }

}
