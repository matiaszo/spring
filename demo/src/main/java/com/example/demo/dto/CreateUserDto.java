package com.example.demo.dto;

public record CreateUserDto(
    String email,
    String username,
    String password
) {}
