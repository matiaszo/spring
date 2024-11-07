package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginData;
import com.example.demo.services.LoginService;

@RestController
// @RequestMapping("/user")
public class UserController {

    @Autowired 
    LoginService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginData data)
    {
        Integer isSuccesfully = service.login(data.login(), data.password());

        if (isSuccesfully == 1)
            System.out.println("Certo o login");
        else
            System.out.println("Errado o login");

        
        if (data.login().equals("name") && data.password().equals("pass"))
            return ResponseEntity.ok("Welcome"); //comenta essa linha e a de cima
        
        return ResponseEntity.status(404).build();
    }
}
