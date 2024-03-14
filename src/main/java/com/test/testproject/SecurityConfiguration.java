package com.test.testproject;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration { //to co chlopek extendowal jest deprecated i usuniete :(

    private final MyUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain securityFilterChainConfig(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests(request ->
                request
                    .requestMatchers("/users/all").hasRole("ADMIN")
                    .requestMatchers("/register").permitAll()
                    .anyRequest().authenticated())
            .formLogin();

        return http.build();
    }
}




