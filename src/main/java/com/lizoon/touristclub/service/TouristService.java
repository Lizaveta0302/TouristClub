package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Tourist;

import java.util.List;
import java.util.Optional;

public interface TouristService {
    Tourist save(Tourist tourist);
    Optional<Tourist> findById(Long id);
    void deleteById(Long id);
    List<Tourist> findAll();
}
