package com.example.backend_cleaningsupplie.registration;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {

    //TODO need to work out format with date in JSON when testing in postman
private final String firstName;
private final String lastName;
private final String username;
private final String password;
private final String email;
private final LocalDate dateOfBirth;





}
