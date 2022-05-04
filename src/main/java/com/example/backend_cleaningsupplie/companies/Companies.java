package com.example.backend_cleaningsupplie.companies;


import com.example.backend_cleaningsupplie.appuser.AppUser;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@EqualsAndHashCode
public class Companies {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;


    @Column(unique = true, nullable = false)
    String companiesName;


    @Column
    String CompaniesPhoneNumber;


    @Column(unique = true)
    String CompaniesEmail;


    @Column
    String CompaniesAdress;

    @OneToMany(mappedBy = "companies")
    Set<AppUser> appUserSet;

    public Companies() {
    }

    public Companies(String companiesName, String companiesPhoneNumber, String companiesEmail, String companiesAdress) {
        this.companiesName = companiesName;
        CompaniesPhoneNumber = companiesPhoneNumber;
        CompaniesEmail = companiesEmail;
        CompaniesAdress = companiesAdress;
    }
}
