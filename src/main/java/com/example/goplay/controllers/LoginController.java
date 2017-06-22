package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import com.example.goplay.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(User user)
    {
        if(loginService.isUserAuthenticated(user))
        {
            return user;
        }
        return "Something wrong";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(User user)
    {
        return loginService.registerUser(user);
    }
}
