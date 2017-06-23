package com.example.goplay.services;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.request.Request;
import com.example.goplay.beans.entity.request.RequestNotification;
import com.example.goplay.beans.request.AnswerRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.repositories.RequestNotificationRepository;
import com.example.goplay.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NotificationService {

    @Autowired
    private RequestNotificationRepository requestNotificationRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private UserService userService;

    public Request createRequest(MatchStartRequest matchStartRequest)
    {
        Request request = new Request();
        List<RequestNotification> requestNotifications = new ArrayList<>();
        List<User> receivers = getReceivers(matchStartRequest);
        for (User user: receivers
             ) {
            requestNotifications.add(new RequestNotification(user, request));
        }

        request.setAccepters(receivers);
        requestRepository.save(request);
        requestNotificationRepository.save(requestNotifications);

        return request;
    }

    public Request getRequestById(Long id)
    {
        return requestRepository.findOne(id);
    }

    public Iterable<RequestNotification> getNotificationsByUser(User user) {
        return requestNotificationRepository.findByReceiver(user);
    }

    public void approveRequest(AnswerRequest answerRequest,User sender) {
        Request request = requestRepository.findOne(answerRequest.getRequestId());
        request.addAcceptor(sender);
    }

    public void disapproveRequest(AnswerRequest answerRequest, User sender) {
        Request request = requestRepository.findOne(answerRequest.getRequestId());
        if(request.getIsApproved() != 1) {
            request.setIsApproved(-1);
        }
    }


    public List<User> getReceivers(MatchStartRequest matchStartRequest) {
        List<User> list = new ArrayList<>();
        list.add(userService.getUser(matchStartRequest.getPlayer12Id()));
        list.add(userService.getUser(matchStartRequest.getPlayer21Id()));
        list.add(userService.getUser(matchStartRequest.getPlayer22Id()));
        return list;
    }
}
