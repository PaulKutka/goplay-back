package com.example.goplay.services;

import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match addMatch(Match match){
        return matchRepository.save(match);
    }
}
