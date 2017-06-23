package com.example.goplay.beans.entity.request;


import com.example.goplay.beans.entity.User;
import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;

    private int approves = 0;

    private int isApproved = 0;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> accepters;

    public Request() {
        accepters = new ArrayList<>();
    }

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

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public void addAcceptor(User user) {
        accepters.add(user);
        approves++;
        if(approves >= 3)
        {
            if(isApproved!= -1)
            {
                isApproved = 1;
            }
        }
    }

    public int getApproves() {
        return approves;
    }

    public void setApproves(int approves) {
        this.approves = approves;
    }
}
