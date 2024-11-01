package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ImaginaryExpoDto;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/imaexp")
public class ImaginaryExpo {

    @GetMapping
    public ImaginaryExpoDto calcImaginary(double A, double b){

        double re = A * Math.sin(b);
        double im = A * Math.cos(b);

        return new ImaginaryExpoDto(re, im);
    }
}
