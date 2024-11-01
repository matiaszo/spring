package com.example.demo.implementations;

import com.example.demo.services.ReverseWordService;

public class ReverseWordImpl implements ReverseWordService{
    
    @Override
    public String palindrome(String input){
        Integer inputSize = input.length();
        String inputReturn = "";

        for(int i = 1; i <= inputSize; i ++){
            inputReturn += String.valueOf(input.charAt(inputSize - i));
        }
        return inputReturn;
    }
}
