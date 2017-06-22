package com.example.goplay.repositories;

import com.example.goplay.beans.entity.team.Team;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by paulius on 17.6.22.
 */
public interface TeamRepository extends CrudRepository<Team, Long> {
}
