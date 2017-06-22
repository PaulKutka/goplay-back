package com.example.goplay.beans.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String time;

    private boolean isAvailable = true;

    public TimeSlot() {}

    public TimeSlot(int hour, int min)
    {
       if(min == 0)
       {
           this.time = hour + ":" + min + "0";
       }
       else
       {
           this.time = hour + ":" + min;
       }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
