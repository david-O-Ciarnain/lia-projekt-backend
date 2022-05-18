package com.example.backend_cleaningsupplie.security.config;

import com.example.backend_cleaningsupplie.appuser.AppUserRole;
import com.example.backend_cleaningsupplie.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    //TODO: csrf need to be enable, permitAll net to change, look upp spring security how to work with csrf, google if you don't know what csrf is


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                /*.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()*/
                .authorizeRequests()
                .antMatchers("/test/registration/**")
                .permitAll()
                .anyRequest()
                .authenticated().and()
                .httpBasic().and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/test/registration/logout")
                .logoutSuccessUrl("/")
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.ACCEPTED))
                .deleteCookies()
                .permitAll();

    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(appUserService);
        return daoAuthenticationProvider;
    }
}
