package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Supervisor;
import com.lizoon.touristclub.repositories.SupervisorRepository;
import com.lizoon.touristclub.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SupervisorController {

    @Autowired
    private SupervisorRepository supervisorRepository;

    private SupervisorService supervisorService;

    @Autowired
    public SupervisorController(SupervisorService supervisorService) {
        this.supervisorService = supervisorService;
    }

    @RequestMapping(value = "/supervisor")
    public String supervisorPage(Model model){

        model.addAttribute("sup",supervisorRepository.findAll());
        return "supervisor";
    }
/*
    @GetMapping(value="/addSupervisor")
    public String viewTheForm(Model model){
        Supervisor supervisor = new Supervisor();
        model.addAttribute("supervisor",supervisor);
        return "adminPage";
    }
    */

    @PostMapping("/addSupervisor")
    public String addSupervisor(@RequestParam String name_supervisor, @RequestParam String last_name,
                                @RequestParam String patronymic, @RequestParam int salary
                               // @Valid @ModelAttribute("supervisor") Supervisor supervisor,
                              //  BindingResult bindingResult, Model model){
    ){
       /* if (bindingResult.hasErrors()) {
            System.out.println("------------BINDING RESULT ERROR" + bindingResult.getAllErrors());
            return "adminPage";
        } else {
        */
            supervisorService.save(new Supervisor(name_supervisor, last_name, patronymic, salary));

        return "redirect:/supervisor";
    }
    @GetMapping("/deleteS/{id}")
    public String deleteSupervisor(@PathVariable Long id) {
        supervisorService.deleteById(id);
        return "redirect:/supervisor";
    }

    @GetMapping("/editS/{id}")
    public String edit(@PathVariable Long id, Model model) {
          Optional<Supervisor> optionalSupervisor = supervisorService.findById(id);
          Supervisor supervisor = optionalSupervisor.get();
          model.addAttribute("supervisor", supervisor);
        return "editSupervisor";
    }
    @PostMapping("/editSupervisor/{id}")
    public String editAndSave(@PathVariable Long id, @RequestParam String supervisor_name,
                              @RequestParam String supervisor_last_name, @RequestParam String supervisor_patronymic,
                              @RequestParam int salary) {

        supervisorService.update(id,supervisor_name,supervisor_last_name,supervisor_patronymic,salary);
        return "redirect:/supervisor";
    }



}
