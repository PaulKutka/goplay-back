package com.example.goplay.beans.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.entity.team.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    private String name;

    private String lastname;

    @JsonIgnore
    private String password;

    @ManyToMany
    private List<Team> teams;

    @Transient
    private List<Match> matches;

    public User() {}

    public User(String name, String lastname, String password, String email)
    {
        this.email = email;
        this.lastname = lastname;
        this.password = password;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Match> getMatches() {
        Set<Match> matches = new HashSet<>();

        for (Team team : teams
             ) {
            matches.addAll(team.getMatches());
        }

        return new ArrayList<>(matches);
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
