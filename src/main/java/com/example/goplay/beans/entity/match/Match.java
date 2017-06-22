package com.example.goplay.beans.entity.match;

import com.example.goplay.beans.entity.team.Team;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "_match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String status;

    private Team team1;

    private Team team2;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
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
}
