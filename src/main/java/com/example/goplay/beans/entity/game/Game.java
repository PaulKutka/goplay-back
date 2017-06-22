package com.example.goplay.beans.entity.game;

import com.example.goplay.beans.entity.TimeSlot;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;


@Entity
public class  Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    @OneToMany
    private List<TimeSlot> timeSlots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
