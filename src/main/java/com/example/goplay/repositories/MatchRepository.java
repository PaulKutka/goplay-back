package com.example.goplay.repositories;

import com.example.goplay.beans.entity.match.Match;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by paulius on 17.6.22.
 */
public interface MatchRepository extends CrudRepository<Match, Long> {
}
