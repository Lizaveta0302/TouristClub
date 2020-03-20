package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Route;
import com.lizoon.touristclub.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class RouteController {

    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }


    @PostMapping("/addRoute")
    public String addRoute(@RequestParam int number_of_days, @RequestParam String data_start) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date data = format.parse(data_start);
        java.sql.Timestamp sDate = new java.sql.Timestamp(data.getTime());
        routeService.save(new Route(number_of_days, sDate));
        return "redirect:/admin";
    }
   /*
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

*/

}
