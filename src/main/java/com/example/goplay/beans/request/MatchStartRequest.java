package com.example.goplay.beans.request;

/**
 * Created by Mantas on 2017.06.22.
 */
public class MatchStartRequest {

    private Long player11Id;
    private Long player12Id;
    private Long player21Id;
    private Long player22Id;

    public MatchStartRequest() {
    }

    public MatchStartRequest(Long player11, Long player12, Long player21, Long player22) {
        this.player11Id = player11;
        this.player12Id = player12;
        this.player21Id = player21;
        this.player22Id = player22;
    }

    public void setPlayer11Id(Long player11Id) {
        this.player11Id = player11Id;
    }

    public void setPlayer12Id(Long player12Id) {
        this.player12Id = player12Id;
    }

    public void setPlayer21Id(Long player21Id) {
        this.player21Id = player21Id;
    }

    public void setPlayer22Id(Long player22Id) {
        this.player22Id = player22Id;
    }

    public Long getPlayer11Id() {
        return player11Id;
    }

    public Long getPlayer12Id() {
        return player12Id;
    }

    public Long getPlayer21Id() {
        return player21Id;
    }

    public Long getPlayer22Id() {
        return player22Id;
    }
}
