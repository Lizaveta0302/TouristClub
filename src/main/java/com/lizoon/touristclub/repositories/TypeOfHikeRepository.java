package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.TypeOfHike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfHikeRepository extends JpaRepository<TypeOfHike,Long> {
}
