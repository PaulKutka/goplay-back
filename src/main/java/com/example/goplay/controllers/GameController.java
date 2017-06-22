package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.game.Game;
import com.example.goplay.services.GameService;
import com.example.goplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<User> getGame() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Game> getGames() {
        return gameService.getAllGames();
    }


}
