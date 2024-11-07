package com.example.demo.services;

public interface PasswordEncoderService {
    String encode(String password);
    boolean checkPassword(String rawPassword, String encodedPassword);
}
