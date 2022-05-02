package com.example.backend_cleaningsupplie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class AppUser {


    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Getter
    @Setter
    @Column
    String user_name;

    @Getter
    @Setter
    @Column
    String password;

    @Getter
    @Setter
    @Column
    String first_name;

    @Getter
    @Setter
    @Column
    String last_name;

    @Getter
    @Setter
    @Column
    int employee_number;

    @Getter
    @Setter
    @Column
    String mail;

    @Getter
    @Setter
    @Column
    LocalDate date_of_birth;


    @Column
    private int age;



    public AppUser(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public AppUser (){

    }
    public int getAge() {
        return Period.between(date_of_birth,LocalDate.now()).getYears();
    }
}
