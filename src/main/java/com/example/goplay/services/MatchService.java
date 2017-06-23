package com.example.goplay.services;

import com.example.goplay.beans.entity.TimeSlot;
import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.entity.team.Team;
import com.example.goplay.beans.request.MatchCancelRequest;
import com.example.goplay.beans.request.MatchFinishedRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.beans.response.MatchResponse;
import com.example.goplay.repositories.MatchRepository;
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
    private TeamService teamService;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private NotificationService notificationService;

    public MatchResponse startMatch(MatchStartRequest matchStartRequest, Long senderId){

        notificationService.createRequest(matchStartRequest);
        TimeSlot timeSlot = timeSlotRepository.findOne(matchStartRequest.getTimeSlotId());
        timeSlot.setAvailable(false);
        timeSlotRepository.save(timeSlot);

        Match match = new Match();

        List<Team> teams = new ArrayList<>();

        Team team1 = teamService.createTeam(senderId, matchStartRequest.getPlayer12Id());
        Team team2 = teamService.createTeam(matchStartRequest.getPlayer21Id(), matchStartRequest.getPlayer22Id());

        teams.add(team1);
        teams.add(team2);

        match.setTeams(teams);
        match.setStatus("pending");

        return new MatchResponse(matchRepository.save(match));
    }

    public MatchResponse finishMatch(MatchFinishedRequest matchFinishedRequest){
        Match match = new Match();
        match.setId(matchFinishedRequest.getId());
        match.setStatus("finished");

        List<Team> teams = new ArrayList();
        teams.add(teamService.setTeam(matchFinishedRequest.getTeam1Id()));
        teams.add(teamService.setTeam(matchFinishedRequest.getTeam2Id()));
        match.setTeams(teams);
        match.setTeam1Result(matchFinishedRequest.getTeam1Result());
        match.setTeam2Result(matchFinishedRequest.getTeam2Result());

        if (match.getTeam1Result() > match.getTeam2Result()) {
            match.setWinner(teamService.getTeam(matchFinishedRequest.getTeam1Id()));
        } else {
            match.setWinner(teamService.getTeam(matchFinishedRequest.getTeam2Id()));
        }

        return new MatchResponse(matchRepository.save(match));
    }

    public MatchResponse cancelMatch(MatchCancelRequest matchCancelRequest){
        Match match = new Match();
        match.setId(matchCancelRequest.getId());
        match.setStatus("canceled");
        return new MatchResponse(matchRepository.save(match));
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
