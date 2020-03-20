package com.lizoon.touristclub.service;

import com.lizoon.touristclub.entity.Section;
import com.lizoon.touristclub.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService{


    private SectionRepository sectionRepository;

    @Autowired
    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @Override
    public Section save(Section section) {

        return sectionRepository.save(section);
    }

    @Override
    public void deleteById(Long id) {
        sectionRepository.deleteById(id);
    }

    @Override
    public Optional<Section> getSectionById(Long id) {
        return sectionRepository.findById(id);
    }

  //  @Override
  //  public Optional<Section> findBySection_Section_name(String section_name) {
  //      return null;//sectionRepository.findBySection_Section_name(section_name);
  //  }

    @Override
    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    @Override
    public void update(Long id, String name) {
        Optional<Section> optionalSection = sectionRepository.findById(id);
        Section section = optionalSection.get();
        section.setSection_name(name);

        sectionRepository.save(section);
    }
}
