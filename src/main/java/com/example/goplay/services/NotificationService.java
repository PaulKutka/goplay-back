package com.example.goplay.services;

import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.request.Request;
import com.example.goplay.beans.entity.request.RequestNotification;
import com.example.goplay.beans.request.AnswerRequest;
import com.example.goplay.beans.request.MatchStartRequest;
import com.example.goplay.beans.response.ColleagueResponse;
import com.example.goplay.beans.response.NotificationResponse;
import com.example.goplay.repositories.RequestNotificationRepository;
import com.example.goplay.repositories.RequestRepository;
import com.example.goplay.repositories.UserRepository;

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
    @Autowired
    private UserRepository userRepository;

    public Request createRequest(MatchStartRequest matchStartRequest, User sender)
    {
        Request request = new Request();
        request.setId(sender.getId());
        List<RequestNotification> requestNotifications = new ArrayList<>();
        List<User> receivers = getReceivers(matchStartRequest);
        for (User user: receivers
             ) {
            requestNotifications.add(new RequestNotification(user, request));
        }
        requestNotificationRepository.save(requestNotifications);
        requestRepository.save(request);

        return request;
    }

    public Request getRequestById(Long id)
    {
        return requestRepository.findOne(id);
    }

    public Iterable<RequestNotification> getNotificationsByUser(User user) {
        return requestNotificationRepository.findByReceiver(user);
    }

    public Iterable<NotificationResponse> convert(User user)
    {
       List<NotificationResponse> list = new ArrayList<>();
        for (RequestNotification requestNotification: getNotificationsByUser(user)
             ) {
            list.add(new NotificationResponse("Einam pazaist?"));
        }
        return list;
    }

    public void approveRequest(AnswerRequest answerRequest,User sender) {
        Request request = requestRepository.findOne(answerRequest.getRequestId());
        request.addAcceptor(sender);
        requestRepository.save(request);
    }

    public void disapproveRequest(AnswerRequest answerRequest, User sender) {
        Request request = requestRepository.findOne(answerRequest.getRequestId());
        if(request.getIsApproved() != 1) {
            request.setIsApproved(-1);
        }
    }

    public List<ColleagueResponse> parseUsersToColleagueResponse(List<User> users )
    {
        List list = new ArrayList();
        for (User user : users
             ) {
            list.add(new ColleagueResponse(user));
        }
        return list;
    }


    public List<User> getReceivers(MatchStartRequest matchStartRequest) {
        List<User> list = new ArrayList<>();
        list.add(userRepository.findUserByName(matchStartRequest.getPlayer12Name()));
        list.add(userRepository.findUserByName(matchStartRequest.getPlayer21Name()));
        list.add(userRepository.findUserByName(matchStartRequest.getPlayer22Name()));
        return list;
    }
}
