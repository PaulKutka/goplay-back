package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.request.LoginRequest;
import com.example.goplay.beans.response.LoginResponse;
import com.example.goplay.services.LoginService;
import com.example.goplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody LoginRequest loginRequest)
    {
            if(loginService.isUserAuthenticated(loginRequest))
            {
                User user = loginService.getUserByEmail(loginRequest.getEmail());
                return user.getToken();
        }

        return "Something wrong";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody User user)
    {
        loginService.registerUser(user);
        return new LoginResponse(loginService.getUserByEmail(user.getEmail()));
    }



}
