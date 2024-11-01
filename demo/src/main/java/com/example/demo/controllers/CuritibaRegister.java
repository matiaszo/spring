package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/backend/curitiba")
public class CuritibaRegister {
    
    // public ResponseEntity<CuritibaRegisterDto> register(String cep, String cpf){

    // }
}
