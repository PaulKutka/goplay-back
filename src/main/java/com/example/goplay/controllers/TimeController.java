package com.example.goplay.controllers;

import com.example.goplay.beans.entity.TimeSlot;
import com.example.goplay.services.GameService;
import com.example.goplay.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
public class TimeController {

    @Autowired
    private TimeService timeService;
    @Autowired
    private GameService gameService;

    @Transactional
    @RequestMapping(value = "/times/{id}", method = RequestMethod.GET)
    public Iterable<TimeSlot> getTimes(@PathVariable Long id)
    {
        timeService.resetTimesForGame(gameService.getGameById(id));
        return timeService.getTimes();
    }

}
