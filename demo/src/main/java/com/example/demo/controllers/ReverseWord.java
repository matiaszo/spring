package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ReverseWordDto;
import com.example.demo.services.ReverseWordService;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/reverse")
public class ReverseWord {

    @Autowired
    ReverseWordService service;

    @GetMapping("/{input}")
    public ReverseWordDto palindrome(@PathVariable String input){
        String reversed = service.palindrome(input);

        if(reversed.equals(input))
            return new ReverseWordDto(reversed, true);
        return new ReverseWordDto(reversed,false);

    }
}
