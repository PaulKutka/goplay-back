package com.example.goplay.services;

import com.example.goplay.beans.entity.TimeSlot;
import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.entity.team.Team;
import com.example.goplay.beans.request.MatchFinishedRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.beans.response.MatchResponse;
import com.example.goplay.repositories.MatchRepository;
import com.example.goplay.repositories.TeamRepository;
import com.example.goplay.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TimeSlotRepository timeSlotRepository;


    public MatchResponse startMatch(MatchStartRequest matchStartRequest){

        TimeSlot timeSlot = timeSlotRepository.findOne(matchStartRequest.getTimeSlotId());
        timeSlot.setAvailable(false);
        timeSlotRepository.save(timeSlot);

        Match match = new Match();


        List<Team> teams = new ArrayList<>();

        Team team1 = teamService.createTeam(matchStartRequest.getPlayer11Id(), matchStartRequest.getPlayer12Id());
        Team team2 = teamService.createTeam(matchStartRequest.getPlayer21Id(), matchStartRequest.getPlayer22Id());

        teams.add(team1);
        teams.add(team2);

        match.setTeams(teams);
        match.setStatus("pending");


        return new MatchResponse(matchRepository.save(match));
    }

    public Match finishMatch(MatchFinishedRequest matchFinishedRequest){
        Match match = new Match();
        match.setId(matchFinishedRequest.getId());
        match.setStatus("finished");

        List<Team> teams = new ArrayList();
        teams.add(teamService.setTeam(matchFinishedRequest.getTeam1Id()));
        teams.add(teamService.setTeam(matchFinishedRequest.getTeam2Id()));
        match.setTeams(teams);
        match.setTeam1Result(matchFinishedRequest.getTeam1Result());
        match.setTeam2Result(matchFinishedRequest.getTeam2Result());

        return matchRepository.save(match);
    }

    public Match cancelMatch(Match match){
        match.setStatus("canceled");
        return matchRepository.save(match);
    }

    public List<MatchResponse> getAllUserMatches(Long userId){
        User user = userService.getUser(userId);
        return convertToMatchResponseList(user.getMatches());
    }

    public List<MatchResponse> getOngoingMatches(){
        return convertToMatchResponseList(matchRepository.findAllByStatus("pending"));
    }

    private List<MatchResponse> convertToMatchResponseList(List<Match> matches) {
        List<MatchResponse> matchResponseList = new ArrayList<>();

        for (int i = 0; i < matches.size(); i++) {
            matchResponseList.add(new MatchResponse(matches.get(i)));
        }

        return matchResponseList;
    }


}
