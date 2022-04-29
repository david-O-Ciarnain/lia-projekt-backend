package com.example.backend_cleaningsupplie.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class AppUser {



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
    String social_security_number;

    @Getter
    @Setter
    @Column
    int employee_number;

    @Getter
    @Setter
    @Column
    String city;

    @Getter
    @Setter
    @Column
    String street;

    @Getter
    @Setter
    @Column
    String post_number;

    @Getter
    @Setter
    @Column
    String tel_number;

    @Getter
    @Setter
    @Column
    String gender;

    @Getter
    @Setter
    @Column
    String mail;


    public AppUser(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public AppUser (){

    }
}
