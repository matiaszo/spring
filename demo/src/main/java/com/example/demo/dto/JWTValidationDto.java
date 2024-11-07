package com.example.demo.dto;

public record JWTValidationDto(
    Token token,
    String titulo,
    String valor 
) {}
