package com.example.backend_cleaningsupplie.appuser;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String username;

    private String password;
    private String email;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private boolean locked = false;
    private boolean enabled = false;



    public AppUser(String firstName, String lastName, String username, String password, String email , LocalDate dateOfBirth , AppUserRole appUserRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.appUserRole = appUserRole;
    }

    public AppUser(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

}
