package com.example.goplay.services;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.match.Match;
import com.example.goplay.beans.response.LeadboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by paulius on 17.6.23.
 */
@Service
public class LeadboardService {

    @Autowired
    private UserService userService;

    public List<LeadboardResponse> getLeadboard(){
        List<LeadboardResponse> leadboardResponseList = new ArrayList<>();

        List<User> users = userService.getAllUsers();

        for (User user : users
              ) {
            LeadboardResponse leadboardResponse = new LeadboardResponse(user);
            int wins = getWins(user);
            int loses = getLoses(user);
            leadboardResponse.setWins(wins);
            leadboardResponse.setLoses(loses);

            leadboardResponseList.add(leadboardResponse);
        }

        leadboardResponseList.sort(new Comparator<LeadboardResponse>() {
            @Override
            public int compare(LeadboardResponse leadboardResponse, LeadboardResponse t1) {
                if (leadboardResponse.getWins() > leadboardResponse.getLoses()){
                    return 1;
                } else if (leadboardResponse.getWins() == leadboardResponse.getLoses()){
                    if(leadboardResponse.getLoses() < t1.getLoses()){
                        return 1;
                    }
                }

                return -1;
            }
        });

        return leadboardResponseList;
    }

    public int getWins(User user) {
        int wins = 0;

        List<Match> userMatches = user.getMatches();

        for (Match match : userMatches) {
            if(match.getWinner().getUsers().contains(user)){
                wins++;
            }
        }

        return wins;
    }

    public int getLoses(User user) {
        int wins = 0;

        List<Match> userMatches = user.getMatches();

        for (Match match : userMatches) {
            if(!match.getWinner().getUsers().contains(user)){
                wins--;
            }
        }

        return wins;
    }
}
