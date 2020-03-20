package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.DistributionSchedule;

import java.util.List;
import java.util.Optional;

public interface DistributionScheduleService {
    DistributionSchedule save(DistributionSchedule distributionSchedule);
    Optional<DistributionSchedule> findById(Long id);
    List<DistributionSchedule> findAll();
    void deleteById(Long id);

}
