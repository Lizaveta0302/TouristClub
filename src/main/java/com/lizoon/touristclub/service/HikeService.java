package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Hike;

import java.util.Optional;

public interface HikeService {
    Hike save(Hike hike);
    Optional<Hike> findById(Long id);
    void deleteById(Long id);
    void update(Long id, String name);
}
