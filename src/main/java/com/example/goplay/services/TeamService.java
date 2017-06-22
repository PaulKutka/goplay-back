package com.example.goplay.services;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.team.Team;
import com.example.goplay.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mantas on 2017.06.22.
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserService userService;

    public Team createTeam(Long player1, Long player2) {
        List<User> userList = new ArrayList<>();
        userList.add(userService.getUser(player1));
        userList.add(userService.getUser(player2));

        List<Team> teams = (List<Team>)teamRepository.findAll();

        for (Team team: teams
             ) {
            if(team.getUsers().containsAll(userList)){
                return team;
            }
            }


        Team team = new Team(userList);
        return teamRepository.save(team);
    }

    public Team setTeam(Long id) {
        return teamRepository.save(teamRepository.findOne(id));
    }

    public Team getTeam(Long id){
        return teamRepository.findOne(id);
    }
}

