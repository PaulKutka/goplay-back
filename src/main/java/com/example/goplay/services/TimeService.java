package com.example.goplay.services;

import com.example.goplay.beans.entity.TimeSlot;
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

    public List<TimeSlot> resetTimes() {
        List<TimeSlot> timeSlotList = new ArrayList<>();
        int hour = HOUR_START;
        int min = 0;
        while(HOUR_END > hour) {
            timeSlotList.add(new TimeSlot(hour, min));
            min += MIN_GAP;
            if(min == 60-MIN_GAP) {
                hour++;
                min = 0;
            }
        }
        timeSlotRepository.deleteAll();
        timeSlotRepository.save(timeSlotList);
        return timeSlotList;
    }

    public TimeSlot reserveTime(int min, int hour)
    {
        TimeSlot timeSlot = timeSlotRepository.findByMinAndHourAndIsAvailableTrue(min, hour);
        if(timeSlot != null)
        {
            timeSlot.setAvailable(false);
            return timeSlotRepository.save(timeSlot);
        }
        return timeSlot;
    }



    public Iterable<TimeSlot> getTimes()
    {
        return timeSlotRepository.findAll();
    }

}
