package com.example.goplay.services;

import com.example.goplay.beans.entity.game.Game;
import com.example.goplay.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulius on 17.6.22.
 */
@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        Iterable<Game> games = gameRepository.findAll();
        List<Game> gamesList = new ArrayList<>();
        for(Game game : games) {
            gamesList.add(game);
        }

        return gamesList;
    }

    public Game getGameById(Long id)
    {
        return gameRepository.findOne(id);
    }


}
