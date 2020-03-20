package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Section;
import com.lizoon.touristclub.entity.Supervisor;
import com.lizoon.touristclub.repositories.SectionRepository;
import com.lizoon.touristclub.service.SectionService;
import com.lizoon.touristclub.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    private SectionService sectionService;
    private SupervisorService supervisorService;

    @Autowired
    public void setSupervisorService(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @Autowired
    public void setSectionService(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/section")
    public String sectionPage(Model model){

        model.addAttribute("sections",sectionRepository.findAll());
        return "section";
    }

    @PostMapping("/addSection")
    public String addSection(@RequestParam String section_name, @RequestParam Long supervisorId) {

        Optional<Supervisor> optionalSupervisor = supervisorService.findById(supervisorId);
        Supervisor supervisor = optionalSupervisor.get();
        sectionService.save(new Section(section_name, supervisor));
        return "redirect:/section";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        sectionService.deleteById(id);
        return "redirect:/section";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Optional<Section> optionalSection = sectionService.getSectionById(id);
        Section section = optionalSection.get();
        model.addAttribute("section", section);
        return "editSection";
    }
    @PostMapping("/editSection/{id}")
    public String editAndSave(@PathVariable Long id, @RequestParam String section_name) {

        sectionService.update(id, section_name);
        return "redirect:/section";
    }

/*
    @RequestMapping(value = "/section")
    public String getSectionBySupervisorId(@RequestParam(value="id_supervisor", required=false, defaultValue="") Long id_supervisor, Model model) {
        List<Section> sections = sectionRepository.findBySupervisorId(id_supervisor);
        model.addAttribute("sections", sections);
        return "section";
    }
*/
}
