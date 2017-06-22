package com.example.goplay.controllers;

import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Match start(Match match) { return matchService.addNewMatch(match); }
}
