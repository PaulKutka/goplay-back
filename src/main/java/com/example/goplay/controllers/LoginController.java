package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.response.LoginResponse;
import com.example.goplay.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody User user)
    {
        if(loginService.isUserAuthenticated(user))
        {
            return "Bearer " + user.getPassword();
        }
        return "Something wrong";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody User user)
    {
        return new LoginResponse(loginService.registerUser(user));
    }
}
