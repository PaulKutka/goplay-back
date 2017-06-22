package com.example.goplay.beans.request;

import com.example.goplay.beans.entity.User;

public class LoginRequest {

    private String email;

    private String password;

    public LoginRequest(User user)
    {
        this.email = user.getEmail();
        this.password = user.getPassword();
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

    public void setPassword(String hashedPassword) {
        this.password = hashedPassword;
    }
}

