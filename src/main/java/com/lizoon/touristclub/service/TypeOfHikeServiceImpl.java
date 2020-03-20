package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.TypeOfHike;
import com.lizoon.touristclub.repositories.TypeOfHikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeOfHikeServiceImpl implements TypeOfHikeService{

    @Autowired
    private TypeOfHikeRepository typeOfHikeRepository;

    public TypeOfHikeServiceImpl(TypeOfHikeRepository typeOfHikeRepository)
    {
        this.typeOfHikeRepository = typeOfHikeRepository;
    }

    @Override
    public TypeOfHike save(TypeOfHike typeOfHike) {

        return typeOfHikeRepository.save(typeOfHike);
    }

    @Override
    public Optional<TypeOfHike> findById(Long id) {
        return typeOfHikeRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        typeOfHikeRepository.deleteById(id);
    }

    @Override
    public void update(Long id, String name) {
      /*  Optional<Hike> optionalHike = hikeRepository.findById(id);
        Hike hike = optionalHike.get();
        hike.setHike_name(name);
        hikeRepository.save(hike);
       */
    }

}
