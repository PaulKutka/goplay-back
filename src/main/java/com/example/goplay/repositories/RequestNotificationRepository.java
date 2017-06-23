package com.example.goplay.repositories;


import com.example.goplay.beans.entity.User;
import com.example.goplay.beans.entity.request.RequestNotification;
import org.springframework.data.repository.CrudRepository;

public interface RequestNotificationRepository extends CrudRepository<RequestNotification, Long> {
    Iterable<RequestNotification> findByReceiver(User receiver);
}
