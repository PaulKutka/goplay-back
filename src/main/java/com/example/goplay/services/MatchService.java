package com.example.goplay.services;

import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulius on 17.6.22.
 */
@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    public Match addNewMatch(Match match) { return addMatch(new Match(match.getMatchStatus())) ; }

    public Match addMatch(Match match){
        return matchRepository.save(match);
    }
}
