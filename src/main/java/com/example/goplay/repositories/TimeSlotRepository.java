package com.example.goplay.repositories;


import com.example.goplay.beans.entity.TimeSlot;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
    TimeSlot findByTimeAndIsAvailableTrue(String date);
}
