package com.example.goplay.beans.response;


import com.example.goplay.beans.entity.User;

public class ColleagueResponse {

    private Long id;

    private String name;

    private String lastname;

    public ColleagueResponse() {}

    public ColleagueResponse(User user) {
        this.id = user.getId();
        this.lastname = user.getLastname();
        this.name = user.getName();
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
}
