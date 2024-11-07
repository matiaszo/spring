package com.example.demo.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.CreateUserDto;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.CreateUserService;

public class CreateUserImplementation implements CreateUserService {
    
    @Autowired
    UserRepository repo;

    public CreateUserImplementation (UserRepository repo){
        this.repo = repo;
    }

    @Override
    public boolean isUsernameValid(String username){

        if (username == null)
            return false;

        if (username.length() < 4)
            return false;

        List<NewUser> users = repo.findByUsername(username);


        return users.isEmpty();

    }

    @Override
    public boolean isEmailValid(String email){

        if (email == null)
            return false;

        String temp = "";

        String[] emailSplited = email.split("@");

        for(String string : emailSplited)
            temp = string;

        if(temp.equals(email))
            return false;

        if (email.length() < 4)
            return false;

        List<NewUser> users = repo.findByEmail(email);
        
        return users.isEmpty();
    }

    @Override
    public boolean isPasswordValid(String password){

        if (password == null)
            return false;

        if (password.length() < 4)
            return false;

        boolean valid;

        if(password.length() < 8)
            return false;

        //verificar maiuscula
        valid = password.chars()
        .anyMatch(c -> c > 64 && c < 91);

        if(!valid)
            return false;
        
        //verificar minuscula
        valid = password.chars()
        .anyMatch(c -> c > 96 && c < 123);
        
        if(!valid)
            return false;
        
        //verificar numero
        valid = password.chars()
        .anyMatch(c -> c > 47 && c < 58);

        return valid;
        }

    @Override
    public boolean validateNullPassword(CreateUserDto user){
        return user.password() != null;
    }

    @Override
    public boolean isUserNameNotOnDatabase(String name){
        List<NewUser> users = this.repo.findByUsername(name);

        return users.isEmpty();
    }
}
