package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JWTValidationDto;
import com.example.demo.services.JWTService;
import com.example.demo.dto.Token;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/product")
public class JWTValidation {
    
    @Autowired
    JWTService<Token> jwtService;

    @Autowired
    UserRepository repo;

    @PostMapping()
    public void validateToken(@RequestAttribute("token") Token token,
    @RequestBody JWTValidationDto product){

        System.out.println(product);
        System.out.println(token.getId());
        System.out.println(token.getId().getClass().getName());
        System.out.println(token.getRole());

        System.out.println();

        Optional<NewUser> user = repo.findById(token.getId());

        // if (!user.isPresent())
        //     return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        // NewUser newUser = user.get();
    }
}
