package com.lizoon.touristclub.repositories;

import com.lizoon.touristclub.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section,Long> {

   // List<Section> findBySupervisorId(Long id_supervisor);
  //  Optional<Section> findBySection_Section_name(String section_name);
}
