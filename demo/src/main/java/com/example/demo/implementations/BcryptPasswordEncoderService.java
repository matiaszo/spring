package com.example.demo.implementations;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.demo.services.PasswordEncoderService;

public class BcryptPasswordEncoderService implements PasswordEncoderService {

    @Override 
    public String encode(String password){
        var encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    @Override
    public boolean checkPassword(String rawPassword, String encodedPassword){
        var encoder = new BCryptPasswordEncoder();
        return encoder.matches(rawPassword, encodedPassword);
    }
}
