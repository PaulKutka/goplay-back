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

    private int min;

    private int hour;

    private boolean isAvailable = true;

    public TimeSlot() {}

    public TimeSlot(int hour, int min)
    {
        this.hour = hour;
        this.min = min;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return hour + ":" + min;
    }

}
