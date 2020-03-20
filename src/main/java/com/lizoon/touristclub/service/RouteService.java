package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Route;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface RouteService {
    Route save(Route route);
    Optional<Route> findById(Long id);
    List<Route> findAll();
    void deleteById(Long id);
    void update(Long id, int number_of_days, Timestamp data_start);
}
