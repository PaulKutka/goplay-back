package com.example.goplay.controllers;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.request.RequestNotification;
import com.example.goplay.beans.request.AnswerRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.beans.response.ColleagueResponse;
import com.example.goplay.beans.response.NotificationResponse;
import com.example.goplay.services.LoginService;
import com.example.goplay.services.NotificationService;
import com.example.goplay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/send", method = RequestMethod.POST)
    Long sendNotifications(@RequestHeader(value = "Authorization", required = false) String token,
                             @RequestBody MatchStartRequest matchStartRequest)
    {
        User sender = loginService.getUserByToken(token);
        notificationService.createRequest(matchStartRequest, sender);
        return loginService.getUserByToken(token).getId();
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    Iterable<NotificationResponse> getNotifications(@RequestHeader(value = "Authorization", required = false) String token)
    {
        return notificationService.convert(loginService.getUserByToken(token));
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    String post(@RequestBody AnswerRequest answerRequest, @RequestHeader(value = "Authorization", required = false) String token)
    {
        User sender = loginService.getUserByToken(token);
        switch (answerRequest.getStatus())
        {
            case 1:
                notificationService.approveRequest(answerRequest, sender);
            case -1:
                notificationService.disapproveRequest(answerRequest, sender);
        }
        return "done";
    }

    @RequestMapping(value = "/status/{requestId}", method = RequestMethod.GET)
    Iterable<ColleagueResponse> getStatus(@PathVariable(value = "requestId") Integer requestId)
    {
       return notificationService.parseUsersToColleagueResponse(notificationService.getRequestById(Long.valueOf(requestId)).getAccepters());
    }
}
