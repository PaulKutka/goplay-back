package com.example.goplay.repositories;


import com.example.goplay.beans.entity.TimeSlot;
import org.springframework.data.repository.CrudRepository;

public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
    TimeSlot findByMinAndHour(int min, int hour);

    TimeSlot findByMinAndHourAndIsAvailableTrue(int min, int hour);
}
