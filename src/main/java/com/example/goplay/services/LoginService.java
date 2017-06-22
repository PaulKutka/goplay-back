package com.example.goplay.services;


import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.request.LoginRequest;
import com.example.goplay.repositories.UserRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Date;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    final private String API_KEY = "tuesisudas";

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

    public boolean isUserAuthenticated(LoginRequest loginRequest) {
        {
            User user = getUserByLoginRequest(loginRequest);
            if(encryptPassword(loginRequest.getPassword()).equals( userRepository.findUserByEmail(user.getEmail()).getPassword()))
            {
                return true;
            }
            return false;
        }
    }
    public User getUserByLoginRequest(LoginRequest loginRequest)
    {
        User user = getUserByEmail(loginRequest.getEmail());
        return user;
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
        user.setToken(createJWT(String.valueOf(user.getId()), user.getEmail(),  3600000));
       return userRepository.save(user);
    }

    private String createJWT(String id, String email, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(API_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .claim("email", email)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }


}
