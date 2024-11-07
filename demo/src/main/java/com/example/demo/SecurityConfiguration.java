package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.filters.JWTAuthenticationFilter;
import com.example.demo.services.JWTService;
import com.example.demo.dto.Token;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    
    @Autowired
    JWTService<Token> jwtService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/reverse").permitAll()
                .requestMatchers("/imaexp").permitAll()
                .requestMatchers("/collatz ").permitAll()
                .requestMatchers("/backend/curitiba").permitAll()
                .requestMatchers("/cities").permitAll()
                .requestMatchers("/cities/query").permitAll()
                .requestMatchers("/create").permitAll()
                .requestMatchers("/changepassword ").permitAll()
                .anyRequest().authenticated()
            )
            .addFilterBefore(new JWTAuthenticationFilter(jwtService), UsernamePasswordAuthenticationFilter.class)
            .build();
    }

}