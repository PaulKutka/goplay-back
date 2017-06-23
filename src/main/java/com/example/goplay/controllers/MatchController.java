package com.example.goplay.controllers;

import com.example.goplay.beans.request.MatchCancelRequest;
import com.example.goplay.beans.request.MatchFinishedRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.beans.response.MatchResponse;
import com.example.goplay.services.LoginService;
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

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public @ResponseBody
    MatchResponse start(@RequestBody MatchStartRequest matchStartRequest, @RequestHeader(value = "Authorization", required = false) String token)
    { return matchService.startMatch(matchStartRequest, loginService.getUserByToken(token).getId()); }

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public @ResponseBody
    MatchResponse finish(@RequestBody MatchFinishedRequest matchFinishedRequest)
    { return matchService.finishMatch(matchFinishedRequest); }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public @ResponseBody
    MatchResponse cancel(@RequestBody MatchCancelRequest matchCancelRequest) { return matchService.cancelMatch(matchCancelRequest); }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody
    List<MatchResponse> cancel(@PathVariable("id") Long id) { return matchService.getAllUserMatches(id); }


    @RequestMapping(value = "/ongoing", method = RequestMethod.GET)
    public @ResponseBody
    List<MatchResponse> getOngoing() { return matchService.getOngoingMatches(); }
}
