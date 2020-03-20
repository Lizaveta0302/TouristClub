package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.Hike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HikeRepository extends JpaRepository<Hike,Long> {
}
