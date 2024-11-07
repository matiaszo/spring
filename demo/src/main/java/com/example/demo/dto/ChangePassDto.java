package com.example.demo.dto;

public record ChangePassDto(
    String username,
    String password,
    String newPassword,
    String repeatPassword
) {}
