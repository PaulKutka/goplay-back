package com.example.goplay.beans.response;

import com.example.goplay.beans.entity.match.Match;

public class MatchResponse extends Response {

    private Long id;
    private Long team1Id;
    private Long team2Id;
    private Long team1Result;
    private Long team2Result;

    private Long requestId;

    public MatchResponse(Match match,Long requestId) {
        id = match.getId();
        team1Id = match.getTeams().get(0).getId();
        team2Id = match.getTeams().get(1).getId();
        team1Result = match.getTeam1Result();
        team2Result = match.getTeam2Result();
        this.requestId = requestId;
    }

    public MatchResponse(Match match) {
        id = match.getId();
        team1Id = match.getTeams().get(0).getId();
        team2Id = match.getTeams().get(1).getId();
        team1Result = match.getTeam1Result();
        team2Result = match.getTeam2Result();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeam1Id() {
        return team1Id;
    }

    public void setTeam1Id(Long team1Id) {
        this.team1Id = team1Id;
    }

    public Long getTeam2Id() {
        return team2Id;
    }

    public void setTeam2Id(Long team2Id) {
        this.team2Id = team2Id;
    }

    public Long getTeam1Result() {
        return team1Result;
    }

    public void setTeam1Result(Long team1Result) {
        this.team1Result = team1Result;
    }

    public Long getTeam2Result() {
        return team2Result;
    }

    public void setTeam2Result(Long team2Result) {
        this.team2Result = team2Result;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
