package com.example.goplay.services;


import com.example.goplay.beans.entity.User;
import com.example.goplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;


    public boolean isUserAuthenticated(User user) {
        {
            if(user.getPassword().equals(userRepository.findUserByEmail(user.getEmail()).getPassword()))
            {
                return true;
            }
            return false;
        }
    }

    public User registerUser(User user) {
        if(userRepository.findUserByEmail(user.getEmail()) != null)
        {
            return null;
        }
        return addUser(new User(user.getName(), user.getLastname(), user.getPassword(), user.getEmail()));
    }

    public User addUser(User user)
    {
       return userRepository.save(user);
    }

}
