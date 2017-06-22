package com.example.goplay.beans.entity;

import com.example.goplay.beans.entity.match.Match;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm");

    private String time;

    private boolean isAvailable = true;

    public TimeSlot() {}

    public TimeSlot(int hour, int min)
    {
       Date date = new Date(0,0,0,hour,min);
       this.time = sdfDate.format(date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
