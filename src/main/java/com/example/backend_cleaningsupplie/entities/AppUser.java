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
import java.time.Period;
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
    String user_name;


    @Column
    String password;


    @Column
    String first_name;


    @Column
    String last_name;

    /* @Column(unique = true)
     int employee_number;
 */
    @Column(unique = true)
    String mail;

    @Column
    LocalDate date_of_birth;

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


    public AppUser(String user_name, String password, String first_name, String last_name, String mail, LocalDate date_of_birth, AppUserRole appUserRole) {
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.mail = mail;
        this.date_of_birth = date_of_birth;
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


