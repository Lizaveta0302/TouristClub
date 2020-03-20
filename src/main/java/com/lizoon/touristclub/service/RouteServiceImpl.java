package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Route;
import com.lizoon.touristclub.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService{

    @Autowired
    private RouteRepository routeRepository;

    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route save(Route route) {
        return routeRepository.save(route);
    }

    @Override
    public Optional<Route> findById(Long id) {
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, int number_of_days, Timestamp data_start) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        Route route = optionalRoute.get();
        route.setNumber_of_days(number_of_days);
        route.setData_start(data_start);
        routeRepository.save(route);
    }

}
