package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.TypeOfHike;

import java.util.Optional;

public interface TypeOfHikeService {
    TypeOfHike save(TypeOfHike typeOfHike);
    Optional<TypeOfHike> findById(Long id);
    void deleteById(Long id);
    void update(Long id, String name);
}
