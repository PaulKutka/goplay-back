package com.example.goplay.repositories;

import com.example.goplay.beans.entity.match.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends CrudRepository<Match, Long> {
}
