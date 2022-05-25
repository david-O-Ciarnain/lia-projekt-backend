package com.example.backend_cleaningsupplie.registration;

import com.example.backend_cleaningsupplie.appuser.roles.Roles;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class RegistrationRequest {

private final String firstName;
private final String lastName;
private final String username;
private final String password;
private final String email;
private final LocalDate dateOfBirth;
private final String roles;






}
