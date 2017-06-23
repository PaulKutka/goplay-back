package com.example.goplay.beans.response;

import org.aspectj.weaver.ast.Not;

public class NotificationResponse {

    private String message;

    private Integer requestId = 1;

    private Long userId;

    public NotificationResponse() {}

    public NotificationResponse(String message) {
        {
            this.message = message;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
