package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Supervisor;
import com.lizoon.touristclub.repositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupervisorServiceImpl implements SupervisorService{

    @Autowired
    private SupervisorRepository supervisorRepository;

    public SupervisorServiceImpl(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    @Override
    public Supervisor save(Supervisor supervisor) {

        return supervisorRepository.save(supervisor);
    }

    @Override
    public Optional<Supervisor> findById(Long id) {
        return supervisorRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        supervisorRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String name, String last_name, String patronymic, int salary) {
        Optional<Supervisor> optionalSupervisor = supervisorRepository.findById(id);
        Supervisor supervisor = optionalSupervisor.get();
        supervisor.setName(name);
        supervisor.setLast_name(last_name);
        supervisor.setPatronymic(patronymic);
        supervisor.setSalary(salary);

        supervisorRepository.save(supervisor);
    }

}
