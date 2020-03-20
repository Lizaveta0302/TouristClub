package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Hike;
import com.lizoon.touristclub.repositories.SupervisorRepository;
import com.lizoon.touristclub.repositories.TypeOfHikeRepository;
import com.lizoon.touristclub.service.HikeService;
import com.lizoon.touristclub.service.TypeOfHikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TypeOfHikeController {

    @Autowired
    private TypeOfHikeRepository typeOfHikeRepository;
    @Autowired
    private SupervisorRepository supervisorRepository;

    private HikeService hikeService;
    @Autowired
    public void setHikeService(HikeService hikeService) {
        this.hikeService = hikeService;
    }

    private TypeOfHikeService typeOfHikeService;
    @Autowired
    public void setTypeOfHikeService(TypeOfHikeService typeOfHikeService) {
        this.typeOfHikeService = typeOfHikeService;
    }

    @RequestMapping(value = "/main")
    public String mainPage(Model model) {
        model.addAttribute("hikes", typeOfHikeRepository.findAll());
        model.addAttribute("sup", supervisorRepository.findAll());
        return "/main";
    }

    @RequestMapping(value = "/hikes")
    public String hikes(Model model) {
        model.addAttribute("hikes", typeOfHikeRepository.findAll());
        return "hikes";
    }
    @PostMapping("/addHike")
    public String addHike(@RequestParam String name_hike) {
        hikeService.save(new Hike(name_hike));
        return "redirect:/main";
    }

    @GetMapping("/deleteH/{id}")
    public String deleteHike(@PathVariable Long id) {
        typeOfHikeService.deleteById(id);
        return "redirect:/hikes";
    }

   }
