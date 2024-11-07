package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.CreateUserService;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/create")
public class CreateUserController {

    @Autowired
    UserRepository repo;

    @Autowired 
    CreateUserService service;

    @PostMapping("")
    public String createNew(@RequestBody CreateUserDto user){

        if (!service.isUsernameValid(user.username())){
        System.out.println("nome invalido");
            return "Invalid name";
        }

        if (!service.isEmailValid(user.email())){
            System.out.println("email invalido");
            return "Invalid email";
        }

        if (!service.isPasswordValid(user.password())){
            System.out.println("senha invalida");

            return "Invalid password";
    }
        NewUser newUser = new NewUser();

        newUser.setEmail(user.email());
        newUser.setUsername(user.username());
        newUser.setPassword(user.password());

        repo.save(newUser);
  
        return "Usuario criado";
    }

}
