package com.example.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CollatzDto;

@RestController
@CrossOrigin(origins={"http://localhost:5257"})
@RequestMapping("/collatz")
public class Collatz {
    
    @GetMapping
    public ResponseEntity<CollatzDto> collatzConjecture(Integer current, Integer step){

            if (current < 0 || step < 0)
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            for(int i = 0; i < step; i++)
                current = collatz(current);
            
            return ResponseEntity.ok(new CollatzDto(current));
    }

    public Integer collatz(Integer current){
        if(current % 2 == 0)
            return current / 2;
        return 3 * current + 1;
    }
}
