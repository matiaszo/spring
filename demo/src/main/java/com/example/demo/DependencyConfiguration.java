package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.implementations.LoginServiceImplementation;
import com.example.demo.implementations.ReverseWordImpl;
import com.example.demo.services.LoginService;
import com.example.demo.services.ReverseWordService;

@Configuration
public class DependencyConfiguration {
    
    @Bean
    // @Scope("singleton")
    @Scope("prototype")
    // @Scope("request")
    // @Scope("session")
    public LoginService loginService(){
        return new LoginServiceImplementation("name", "pass");
    }

    @Bean
    @Scope("singleton")
    public ReverseWordService reverseService(){
        return new ReverseWordImpl(); 
    }
}
