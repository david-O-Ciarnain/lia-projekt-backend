package com.example.backend_cleaningsupplie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class AppUser {


    @Getter
    @Setter
    @Id
    @Getter
    @Setter
    @NonNull
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

    @ManyToOne
    @JoinColumn(name = "companies_id", nullable = false)
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
