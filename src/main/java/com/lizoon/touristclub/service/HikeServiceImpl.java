package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Hike;
import com.lizoon.touristclub.repositories.HikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HikeServiceImpl implements HikeService{

    @Autowired
    private HikeRepository hikeRepository;

    public HikeServiceImpl(HikeRepository hikeRepository) {
        this.hikeRepository = hikeRepository;
    }

    @Override
    public Hike save(Hike hike) {
        return hikeRepository.save(hike);
    }

    @Override
    public Optional<Hike> findById(Long id) {
        return hikeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        hikeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String name) {
        Optional<Hike> optionalHike = hikeRepository.findById(id);
        Hike hike = optionalHike.get();
        hike.setHike_name(name);
        hikeRepository.save(hike);
    }

}
