package com.example.goplay.beans.request;


public class AnswerRequest {

    private int status;

    private Long requestId;

    public AnswerRequest() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
}
