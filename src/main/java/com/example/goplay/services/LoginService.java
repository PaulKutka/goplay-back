package com.example.goplay.services;


import com.example.goplay.beans.entity.User;
import com.example.goplay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public String encryptPassword(String password) {

        return getSha256(password);
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public static String getSha256(String value) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(value.getBytes());
            return bytesToHex(md.digest());
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

    public boolean isUserAuthenticated(User user) {
        {
            if(encryptPassword(user.getPassword()).equals( userRepository.findUserByEmail(user.getEmail()).getPassword()))
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
        return addUser(new User(user.getName(), user.getLastname(), encryptPassword(user.getPassword()), user.getEmail()));
    }

    public User addUser(User user)
    {
       return userRepository.save(user);
    }

}
