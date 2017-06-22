package com.example.goplay.beans.entity.team;


import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.match.Match;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany
    private List<User> users;


    @ManyToMany
    private List<Match> matches;

    public Team() {
    }

    public Team(String name, List<User> users, List<Match> matches) {
        this.name = name;
        this.users = users;
        this.matches = matches;
    }

    public Team(List<User> userList) {
        this.users = userList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

}
