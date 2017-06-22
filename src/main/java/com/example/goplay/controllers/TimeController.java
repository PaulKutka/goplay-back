package com.example.goplay.controllers;

import com.example.goplay.beans.entity.TimeSlot;
import com.example.goplay.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/times", method = RequestMethod.GET)
    public Iterable<TimeSlot> getTimes()
    {
        timeService.resetTimes();
        return timeService.getTimes();
    }

}
