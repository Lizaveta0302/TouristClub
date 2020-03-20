package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {
    Section save(Section section);
    void deleteById(Long id);
    Optional<Section> getSectionById(Long id);
   // Optional<Section> findBySection_Section_name(String section_name);
    List<Section> findAll();
    void update(Long id, String name);

}
