package com.example.goplay.beans.entity.request;


import com.example.goplay.beans.entity.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    @OneToMany
    private List<User> accepters;

    public Request() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<User> getAccepters() {
        return accepters;
    }

    public void setAccepters(List<User> accepters) {
        this.accepters = accepters;
    }
}
