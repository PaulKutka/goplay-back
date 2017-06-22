package com.example.goplay.beans.request;

import com.example.goplay.beans.entity.User;

public class LoginRequest {

    private String email;

    private String hashedPassword;

    public LoginRequest(User user)
    {
        this.email = user.getEmail();
        this.hashedPassword = user.getPassword();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}

