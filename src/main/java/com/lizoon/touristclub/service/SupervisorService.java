package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Supervisor;

import java.util.Optional;

public interface SupervisorService {
    Supervisor save(Supervisor supervisor);
    Optional<Supervisor> findById(Long id);
    void deleteById(Long id);
    void update(Long id, String name, String last_name, String patronymic, int salary);
}
