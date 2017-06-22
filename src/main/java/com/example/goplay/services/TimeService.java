package com.example.goplay.services;

import com.example.goplay.beans.entity.TimeSlot;
import com.example.goplay.beans.entity.game.Game;
import com.example.goplay.repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TimeService {

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    private final int HOUR_START = 8;
    private final int HOUR_END = 19;
    private final int MIN_GAP = 30;

    public List<TimeSlot> resetTimesForGame(Game game) {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        int hour = HOUR_START;
        int min = 0;
        while(HOUR_END > hour) {
            timeSlotList.add(new TimeSlot(hour, min, game));
            min += MIN_GAP;
            if(min >= 60) {
                hour++;
                min = 0;
            }
        }
        timeSlotRepository.deleteAllByGame(game);
        timeSlotRepository.save(timeSlotList);
        return timeSlotList;
    }

    public TimeSlot reserveTime(int min, int hour)
    {
        TimeSlot timeSlot = timeSlotRepository.findByTimeAndIsAvailableTrue(getTimeFromHourAndMin(hour, min));
        if(timeSlot != null)
        {
            timeSlot.setAvailable(false);
            return timeSlotRepository.save(timeSlot);
        }
        return timeSlot;
    }

    public String getTimeFromHourAndMin(int hour, int min)
    {
        return hour+":"+min;
    }


    public Iterable<TimeSlot> getTimes()
    {
        return timeSlotRepository.findAll();
    }

}
