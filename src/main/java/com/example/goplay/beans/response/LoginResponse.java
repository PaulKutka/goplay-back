package com.example.goplay.beans.response;

import com.example.goplay.beans.entity.User;

/**
 * Created by Vilius on 2017-06-22.
 */
public class LoginResponse {

    private Long id;

    private String email;

    private String name;

    private String lastname;

    private String password;

    public LoginResponse() {}

    public LoginResponse(User user){
        this.email = user.getEmail();
        this.id = user.getId();
        this.lastname = user.getLastname();
        this.password = getPassword();
        this.name = user.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
