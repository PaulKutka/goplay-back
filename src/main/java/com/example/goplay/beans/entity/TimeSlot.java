package com.example.goplay.beans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static jdk.nashorn.internal.objects.NativeString.concat;

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
       String timeString = hour + ":" + min;
               this.time =  new SimpleDateFormat("HH:mm")
                        .format(new Date())
                        .concat(timeString);
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
