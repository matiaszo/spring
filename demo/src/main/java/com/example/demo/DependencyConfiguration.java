package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.demo.dto.Token;
import com.example.demo.implementations.BcryptPasswordEncoderService;
import com.example.demo.implementations.CreateUserImplementation;
import com.example.demo.implementations.LoginServiceImplementation;
import com.example.demo.implementations.ReverseWordImpl;
import com.example.demo.services.CreateUserService;
import com.example.demo.services.JWTService;
import com.example.demo.services.LoginService;
import com.example.demo.services.PasswordEncoderService;
import com.example.demo.services.ReverseWordService;
import com.example.demo.implementations.JWTImplementation;

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

    @Bean
    public PasswordEncoderService passwordEncoderService() {
        return new BcryptPasswordEncoderService();
    }

    @Bean
    public CreateUserService createNewService(){
        return new CreateUserImplementation(null);
    }

    @Bean
    public JWTService<Token> jwtService(){
        return new JWTImplementation();
    }
}
