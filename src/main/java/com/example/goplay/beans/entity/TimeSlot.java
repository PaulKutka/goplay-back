package com.example.goplay.beans.entity;

import com.example.goplay.beans.entity.game.Game;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Game game;

    private String time;

    private boolean isAvailable = true;

    public TimeSlot() {}

    public TimeSlot(int hour, int min, Game game)
    {
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
