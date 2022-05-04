package com.example.backend_cleaningsupplie.registration;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class RegistrationRequest {


    private final String userName;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String mail;
    private final LocalDate dateOfBirth;

}
