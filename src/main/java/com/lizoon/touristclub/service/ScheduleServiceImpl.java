package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Schedule;
import com.lizoon.touristclub.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    @Autowired
    private ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return scheduleRepository.findById(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String place, Timestamp date, int duration) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        Schedule schedule = optionalSchedule.get();
        schedule.setPlace(place);
        schedule.setData(date);
        schedule.setDuration(duration);
        scheduleRepository.save(schedule);
    }

}
