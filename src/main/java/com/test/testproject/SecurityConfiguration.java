package com.test.testproject;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration { //to co chlopek extendowal jest deprecated i usuniete :(
    @Bean
    public SecurityFilterChain securityFilterChainConfig(HttpSecurity http) throws Exception {

        return http
            .csrf(csrf -> csrf.disable())
            .httpBasic(Customizer.withDefaults()) //basic auth z username i password
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/admin**").hasRole("ADMIN"); //antMatchers jak koło nie istnieje
                auth.requestMatchers("/login**").permitAll();
                auth.requestMatchers("/beers**").permitAll(); //do /admin bedzie przypisane dodawanie piwa a do /beers przegladanie czy cos
                auth.anyRequest().authenticated();
            })
            .formLogin(Customizer.withDefaults())
            .exceptionHandling(exception -> {
                exception.authenticationEntryPoint(
                    ((request, response, authException) -> {
                        System.out.println(authException.getCause() +"/t"+authException.getMessage());
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                    })
                );
            })
            .logout(logout->{
                logout.permitAll();
            })
            .build();
    }
}


