package com.example.goplay.beans.request;

/**
 * Created by Mantas on 2017.06.23.
 */
public class MatchCancelRequest {

    private Long id;

    public MatchCancelRequest() {

    }

    public MatchCancelRequest(Long id) {

        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
