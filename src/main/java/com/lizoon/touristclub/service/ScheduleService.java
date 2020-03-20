package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Schedule;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    Schedule save(Schedule schedule);
    Optional<Schedule> findById(Long id);
    List<Schedule> findAll();
    void deleteById(Long id);
    void update(Long id, String place, Timestamp date, int duration);
}
