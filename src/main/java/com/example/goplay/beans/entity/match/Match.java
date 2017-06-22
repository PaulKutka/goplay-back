package com.example.goplay.beans.entity.match;

import com.example.goplay.beans.entity.team.Team;

import javax.persistence.*;
import java.util.List;


@Entity(name = "match_")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String status;

    @ManyToMany
    private List<Team> teams;


    private Long team1Result;

    private Long team2Result;

    public Match() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
