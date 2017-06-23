package com.example.goplay.beans.response;

import com.example.goplay.beans.entity.User;

public class UserResponse extends Response {

    private Long id;

    private String name;

    public UserResponse(User user) {
        id = user.getId();
        name = user.getName();
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
}
