package com.example.goplay.beans.entity.team;


import com.example.goplay.beans.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ManyToMany
    protected List<User> users;

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

}
