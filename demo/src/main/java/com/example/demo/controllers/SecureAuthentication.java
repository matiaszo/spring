package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginData;
import com.example.demo.dto.Token;
import com.example.demo.dto.TokenLogin;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.CreateUserService;
import com.example.demo.services.JWTService;
import com.example.demo.services.PasswordEncoderService;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/login")
public class SecureAuthentication {
    
    @Autowired
    CreateUserService service;

    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoderService encoder;
    
    Token token = new Token();

    @Autowired
    JWTService<Token> jwtService;

    @PostMapping
    public ResponseEntity<TokenLogin> autenticate(@RequestBody LoginData user){
        if (service.isUserNameNotOnDatabase(user.login()))
            return new ResponseEntity<>(new TokenLogin("User not found","null"),HttpStatus.NOT_FOUND);

        List<NewUser> users = repo.findByUsername(user.login());
        NewUser loggedUser = users.get(0);

        if(!encoder.checkPassword(user.password(), loggedUser.getPassword()))
            return new ResponseEntity<>(new TokenLogin("Login failed","null"),HttpStatus.NOT_ACCEPTABLE);


        token.setId(loggedUser.getId());
        token.setRole(loggedUser.getUsername());

        var jwt = jwtService.get(token);

        return new ResponseEntity<>(new TokenLogin("Login succesfull",String.valueOf(jwt)), HttpStatus.OK);
    }
}
