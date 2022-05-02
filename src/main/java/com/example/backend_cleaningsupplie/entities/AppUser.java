package com.example.backend_cleaningsupplie.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table
public class AppUser {



    @Id
    @SequenceGenerator(
            name = "appuser_sequence",
            sequenceName = "appuser-sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "appuser_sequence")
    int id;


    @Column(unique = true)
    String user_name;


    @Column
    String password;


    @Column
    String first_name;


    @Column
    String last_name;

    @Column(unique = true)
    int employee_number;

    @Column(unique = true)
    String mail;

    @Column
    LocalDate date_of_birth;

    @Column
    private int age;

    @ManyToOne
    @JoinColumn(name = "companies_id")
    private Companies companies;




    public AppUser(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public AppUser(String user_name, String password, String first_name, String last_name, int employee_number, String mail, LocalDate date_of_birth) {
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.employee_number = employee_number;
        this.mail = mail;
        this.date_of_birth = date_of_birth;
    }

    public AppUser (){

    }
    public int getAge() {
        return Period.between(date_of_birth,LocalDate.now()).getYears();
    }
}
