package com.example.backend_cleaningsupplie.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class AppUser {

    public AppUser (){}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    @Column
    String first_name;

    @Column
    String last_name;

    @Column
    String social_security_number;

    @Column
    int employee_number;

    @Column
    String city;

    @Column
    String street;

    @Column
    int post_number;

    @Column
    String tel_number;

    @Column
    String gender;

    @Column
    String mail;




}
