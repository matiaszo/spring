package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ChangePassDto;
import com.example.demo.model.NewUser;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.CreateUserService;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/changepassword")
public class ChangePass {

    @Autowired
    UserRepository repo;

    @Autowired
    CreateUserService service;

    @PatchMapping("")
    public String changePassword(@RequestBody ChangePassDto body){

        if (!service.isUserNameNotOnDatabase(body.username()))
            return "Usuario não registrado.";

        List<NewUser> users = this.repo.findByUsername(body.username());
        NewUser user = users.get(0);

        if (!user.getPassword().equals(body.password()))
            return "Senha incorreta";
            
        if (!service.isPasswordValid(body.newPassword()))
            return "Nova senha inválida";

        if (!service.isPasswordValid(body.repeatPassword()))
            return "Repetição da nova senha inválida";

        if (body.password().equals(body.newPassword()))
            return "Sua senha deve ser diferente da anterior";

        if (!body.newPassword().equals(body.repeatPassword()))
            return "A senha repetida deve ser a mesma";


        user.setPassword(body.newPassword());
        repo.save(user);

        return "Senha alterada com sucesso!";
    }
}
