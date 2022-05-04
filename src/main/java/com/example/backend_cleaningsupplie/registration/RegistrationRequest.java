package com.example.backend_cleaningsupplie.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String mail;
    private final LocalDate dateOfBirth;
}
