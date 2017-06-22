package com.example.goplay.beans.response;

import com.example.goplay.beans.entity.User;

/**
 * Created by paulius on 17.6.23.
 */
public class LeadboardResponse extends Response {

    private UserResponse user;

    private int wins;

    private int loses;

    public LeadboardResponse(User user) {
        this.user = new UserResponse(user);

    }
    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }
}
