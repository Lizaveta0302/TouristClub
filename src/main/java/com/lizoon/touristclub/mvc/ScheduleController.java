package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Schedule;
import com.lizoon.touristclub.service.DistributionScheduleService;
import com.lizoon.touristclub.service.ScheduleService;
import com.lizoon.touristclub.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class ScheduleController {

    private ScheduleService scheduleService;
    private DistributionScheduleService distributionScheduleService;
    private SectionService sectionService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService,
                              DistributionScheduleService distributionScheduleService,
                              SectionService sectionService) {
        this.scheduleService = scheduleService;
        this.distributionScheduleService = distributionScheduleService;
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/schedule")
    public String supervisorPage(Model model){

        model.addAttribute("schedule",distributionScheduleService.findAll());
        return "schedule";
    }

    @PostMapping("/addSchedule")
    public String addSchedule(@RequestParam String place, @RequestParam String date, @RequestParam int duration, @RequestParam String section) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date data = format.parse(date);
        java.sql.Timestamp sDate = new java.sql.Timestamp(data.getTime());
        Schedule schedule = new Schedule(place, sDate, duration);
        scheduleService.save(schedule);
/*
        Optional<Section> optionalSection = sectionService.getSectionByName(section);
        Section section1 = optionalSection.get();

        DistributionSchedule distributionSchedule = new DistributionSchedule(section1, schedule);
        distributionScheduleService.save(distributionSchedule);

 */
        return "redirect:/admin";
    }

    @GetMapping("/deleteSC/{id}")
    public String deleteSupervisor(@PathVariable Long id) {
        distributionScheduleService.deleteById(id);
        return "redirect:/schedule";
    }
/*
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

*/

}
