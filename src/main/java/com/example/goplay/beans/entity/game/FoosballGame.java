package com.example.goplay.beans.entity.game;


import com.example.goplay.beans.entity.team.Team;

import javax.persistence.*;

@Entity
public class FoosballGame implements Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int winnerResult;

    private int looserResult;

    @OneToOne
    protected Team winnerTeam;

    @OneToOne
    protected Team looserTeam;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWinnerResult() {
        return winnerResult;
    }

    public void setWinnerResult(int winnerResult) {
        this.winnerResult = winnerResult;
    }

    public int getLooserResult() {
        return looserResult;
    }

    public void setLooserResult(int looserResult) {
        this.looserResult = looserResult;
    }

    public Team getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(Team winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public Team getLooserTeam() {
        return looserTeam;
    }

    public void setLooserTeam(Team looserTeam) {
        this.looserTeam = looserTeam;
    }

}
