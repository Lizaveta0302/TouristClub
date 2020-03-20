package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Tourist;
import com.lizoon.touristclub.repositories.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TouristServiceImpl implements TouristService{

    @Autowired
    private TouristRepository touristRepository;

    public TouristServiceImpl(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    @Override
    public Tourist save(Tourist tourist) {
        return touristRepository.save(tourist);
    }

    @Override
    public Optional<Tourist> findById(Long id) {
        return touristRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        touristRepository.deleteById(id);
    }

    @Override
    public List<Tourist> findAll() {
        return touristRepository.findAll();
    }


}
