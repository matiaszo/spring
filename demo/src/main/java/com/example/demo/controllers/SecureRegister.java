package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.CreateUserDto;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.CreateUserService;
import com.example.demo.services.PasswordEncoderService;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/user")
public class SecureRegister {
    
    @Autowired
    UserRepository repo;

    @Autowired
    PasswordEncoderService encoder;

    @Autowired
    CreateUserService service;

    @PostMapping("")
    public ResponseEntity<String> registerWithBCrypt(@RequestBody CreateUserDto user){

        if (!service.isUsernameValid(user.username())){
            System.out.println("nome invalido");
            return new ResponseEntity<>("Invalid name", HttpStatus.BAD_REQUEST);
            }
    
        if (!service.isEmailValid(user.email())){
            System.out.println("email invalido");
            return new ResponseEntity<>("Invalid email", HttpStatus.BAD_REQUEST);
        }

        if (!service.validateNullPassword(user))
            return new ResponseEntity<>("Invalid password", HttpStatus.BAD_REQUEST);

        String password = this.encoder.encode(user.password());

        NewUser temp = new NewUser();

        temp.setUsername(user.username());
        temp.setEmail(user.email());
        temp.setPassword(password);

        repo.save(temp);

        return new ResponseEntity<>("User created!", HttpStatus.BAD_REQUEST);
    }
}
