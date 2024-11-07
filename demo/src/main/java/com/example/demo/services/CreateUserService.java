package com.example.demo.services;

import com.example.demo.dto.CreateUserDto;

public interface CreateUserService {
    public boolean isUsernameValid(String username);
    public boolean isEmailValid(String email);
    public boolean isPasswordValid(String password);
    public boolean validateNullPassword(CreateUserDto user);
    public boolean isUserNameNotOnDatabase(String name);
}
