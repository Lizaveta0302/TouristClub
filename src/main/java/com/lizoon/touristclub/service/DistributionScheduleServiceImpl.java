package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.DistributionSchedule;
import com.lizoon.touristclub.repositories.DistributionScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistributionScheduleServiceImpl implements DistributionScheduleService{

    @Autowired
    private DistributionScheduleRepository distributionScheduleRepository;

    public DistributionScheduleServiceImpl(DistributionScheduleRepository distributionScheduleRepository) {
        this.distributionScheduleRepository = distributionScheduleRepository;
    }

    @Override
    public DistributionSchedule save(DistributionSchedule schedule) {
        return distributionScheduleRepository.save(schedule);
    }

    @Override
    public Optional<DistributionSchedule> findById(Long id) {
        return distributionScheduleRepository.findById(id);
    }

    @Override
    public List<DistributionSchedule> findAll() {
        return distributionScheduleRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        distributionScheduleRepository.deleteById(id);
    }



}
