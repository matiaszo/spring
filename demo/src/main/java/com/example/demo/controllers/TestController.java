package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SumResult;

@RestController 
@RequestMapping("/test")
public class TestController {
    
    @GetMapping ("/{a}/{b}/{c}")
    public SumResult secondGrade(@PathVariable Integer a, @PathVariable Integer b, @PathVariable Integer c){
        Integer det = (b * b) - (4 * a * c);
        Double result1 = ((b * - 1) + Math.sqrt(det))/2 * a;
        Double result2 = ((b * - 1) - Math.sqrt(det))/2 * a;

        boolean isResult1Even = result1 % 2 == 0;
        boolean isResult2Even = result2 % 2 == 0;
        return new SumResult(result1, result2, isResult1Even, isResult2Even);
    }
}
