package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.DistributionSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionScheduleRepository extends JpaRepository<DistributionSchedule,Long> {
}
