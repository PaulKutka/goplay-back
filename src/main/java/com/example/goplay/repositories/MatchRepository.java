package com.example.goplay.repositories;

import com.example.goplay.beans.entity.match.Match;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository<Match, Long> {
}
