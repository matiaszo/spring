package com.example.demo.implementations;

import com.example.demo.services.LoginService;

public class LoginServiceImplementation implements LoginService {
    
    String realLogin;
    String realPass;

    public LoginServiceImplementation(String realLogin, String realPass)
    {
        this.realLogin = realLogin;
        this.realPass = realPass;
    }

    @Override
    public Integer login(String username, String password){
        if (!username.equals(realLogin))
            return -1;

        if (!password.equals(realPass))
            return -1;

        return 1;
    }
}
