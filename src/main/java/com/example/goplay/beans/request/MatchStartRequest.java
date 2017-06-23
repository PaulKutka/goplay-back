package com.example.goplay.beans.request;

import javax.persistence.OneToOne;

/**
 * Created by Mantas on 2017.06.22.
 */
public class MatchStartRequest {

    @OneToOne
    private Long timeSlotId;

    private String player12Name;
    private String player21Name;
    private String player22Name;

    public MatchStartRequest(Long timeSlotId, String player12Name, String player21Name, String player22Name) {
        this.timeSlotId = timeSlotId;
        this.player12Name = player12Name;
        this.player21Name = player21Name;
        this.player22Name = player22Name;
    }

    public MatchStartRequest() {
    }

    public String getPlayer12Name() {
        return player12Name;
    }

    public void setPlayer12Name(String player12Name) {
        this.player12Name = player12Name;
    }

    public String getPlayer21Name() {
        return player21Name;
    }

    public void setPlayer21Name(String player21Name) {
        this.player21Name = player21Name;
    }

    public String getPlayer22Name() {
        return player22Name;
    }

    public void setPlayer22Name(String player22Name) {
        this.player22Name = player22Name;
    }

    public Long getTimeSlotId () {
        return timeSlotId;
    }
    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }
}
