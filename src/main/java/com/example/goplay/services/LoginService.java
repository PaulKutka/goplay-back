package com.example.goplay.services;


import com.example.goplay.beans.entity.User;
import com.example.goplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encryptPassword(String password) {

        return passwordEncoder.encode(password);
    }

    public boolean isUserAuthenticated(User user) {
        {
            if(passwordEncoder.matches(user.getPassword(), userRepository.findUserByEmail(user.getEmail()).getPassword()))
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
