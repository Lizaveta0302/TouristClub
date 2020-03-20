package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupervisorRepository extends JpaRepository<Supervisor,Long> {

}
