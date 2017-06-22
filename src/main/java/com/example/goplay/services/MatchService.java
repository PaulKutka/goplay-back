package com.example.goplay.services;

import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.request.MatchFinishedRequest;
import com.example.goplay.repositories.MatchRepository;
import com.example.goplay.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamRepository teamRepository;

    public Match startMatch(Match match){
        match.setStatus("pending");
        return matchRepository.save(match);
    }

    public Match finishMatch(MatchFinishedRequest matchFinishedRequest){
        Match match = new Match();
        match.setId(matchFinishedRequest.getId());
        match.setStatus("finished");
        match.setTeam1(teamRepository.findOne(matchFinishedRequest.getTeam1Id()));
        match.setTeam2(teamRepository.findOne(matchFinishedRequest.getTeam2Id()));
        match.setTeam1Result(matchFinishedRequest.getTeam1Result());
        match.setTeam2Result(matchFinishedRequest.getTeam2Result());

        return matchRepository.save(match);
    }

    public Match cancelMatch(Match match){
        match.setStatus("canceled");
        return matchRepository.save(match);
    }
}
