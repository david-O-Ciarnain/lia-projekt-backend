package com.example.backend_cleaningsupplie.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table

public class Companies {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Getter
    @Setter
    @Column
    String companiesName;

    @Getter
    @Setter
    @Column
    String CompaniesPhoneNumber;

    @Getter
    @Setter
    @Column
    String CompaniesEmail;

    @Getter
    @Setter
    @Column
    String CompaniesAdress;

    public Companies() {
    }

    public Companies(String companiesName, String companiesPhoneNumber, String companiesEmail, String companiesAdress) {
        this.companiesName = companiesName;
        CompaniesPhoneNumber = companiesPhoneNumber;
        CompaniesEmail = companiesEmail;
        CompaniesAdress = companiesAdress;
    }
}
