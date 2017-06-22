package com.example.goplay.repositories;

import com.example.goplay.beans.entity.game.Game;
import org.springframework.data.repository.CrudRepository;


public interface GameRepository extends CrudRepository<Game, Long> {
}
