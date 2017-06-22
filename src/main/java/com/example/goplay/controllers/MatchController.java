package com.example.goplay.controllers;

import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.request.MatchFinishedRequest;
import com.example.goplay.beans.response.MatchResponse;
import com.example.goplay.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public @ResponseBody
    Match start(@RequestBody Match match) { return matchService.startMatch(match); }

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public @ResponseBody
    Match finish(@RequestBody MatchFinishedRequest match) { return matchService.finishMatch(match); }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public @ResponseBody
    Match cancel(@RequestBody Match match) { return matchService.cancelMatch(match); }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<MatchResponse> cancel(@PathVariable("id") Long id) { return matchService.getAllUserMatches(id); }
}
