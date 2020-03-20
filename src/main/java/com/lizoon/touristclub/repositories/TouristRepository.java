package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist,Long> {

   // List<Section> findBySupervisorId(Long id_supervisor);
  //  Optional<Section> findBySection_Section_name(String section_name);
}
