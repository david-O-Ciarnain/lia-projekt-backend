package com.example.backend_cleaningsupplie.registration.token;

import com.example.backend_cleaningsupplie.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Token {


    @Id
    @SequenceGenerator(
            name = "token_sequence",
            sequenceName = "token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private LocalDateTime createAt;

    @Column(nullable = false)
    private LocalDateTime expiredAt;
    private LocalDateTime confirmAt;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    public AppUser appUser;

    public Token(String token, LocalDateTime createAt, LocalDateTime expiredAt, AppUser appUser) {
        this.token = token;
        this.createAt = createAt;
        this.expiredAt = expiredAt;
        this.appUser = appUser;
    }
}
