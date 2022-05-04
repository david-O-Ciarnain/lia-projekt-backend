package com.example.backend_cleaningsupplie.entities;

import com.example.backend_cleaningsupplie.userrole.AppUserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table
@NoArgsConstructor
public class AppUser implements UserDetails {

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
    String userName;


    @Column
    String password;


    @Column
    String firstName;


    @Column
    String lastName;

    /* @Column(unique = true)
     int employee_number;
 */
    @Column(unique = true)
    String mail;

    @Column
    LocalDate dateOfBirth;

    @Column
    @Enumerated(EnumType.STRING)
    AppUserRole appUserRole;

    @Column
    boolean locked = false;

    @Column
    boolean enabled = false;



    @ManyToOne
    @JoinColumn(name = "companies_id")
    private Companies companies;


    public AppUser(String user_name, String password, String firstName, String last_name, String mail, LocalDate dateOfBirth, AppUserRole appUserRole) {
        this.userName = user_name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = last_name;
        this.mail = mail;
        this.dateOfBirth = dateOfBirth;
        this.appUserRole = appUserRole;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}


