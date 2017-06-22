package com.example.goplay.services;

import com.example.goplay.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by paulius on 17.6.22.
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


}
