package com.example.goplay.repositories;

import com.example.goplay.beans.entity.team.Team;
import org.springframework.data.repository.CrudRepository;


public interface TeamRepository extends CrudRepository<Team, Long> {
}
