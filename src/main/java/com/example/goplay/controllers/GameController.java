package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.goplay.services.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<User> getGame(){
        return userService.getAllUsers();
    }


}
