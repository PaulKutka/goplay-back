package com.example.goplay.services;


import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.response.ColleagueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.goplay.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<ColleagueResponse> getColleagues()
    {
        List<ColleagueResponse> list = new ArrayList<>();
        for (User user : getAllUsers()
             ) {
            list.add(new ColleagueResponse(user));
        }
        return list;
    }


    public List<User> getAllUsers(){
        return (List<User>)userRepository.findAll();
    }

    public User getUser(Long userId) {
        return userRepository.findOne(userId);
    }

}
