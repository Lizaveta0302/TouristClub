package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Tourist;
import com.lizoon.touristclub.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class TouristController {

    @Autowired
    private TouristService touristService;

    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }

    @RequestMapping(value = "/tourist")
    public String sectionPage(Model model){

        model.addAttribute("tourist",touristService.findAll());
        return "tourist";
    }

    @PostMapping("/addTourist")
    public String addTourist(@RequestParam String name,
                             @RequestParam String last_name,
                             @RequestParam String patronymic,
                             @RequestParam String gender,
                             @RequestParam String birthday) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date data = format.parse(birthday);
        java.sql.Timestamp sDate = new java.sql.Timestamp(data.getTime());
        Tourist tourist = new Tourist(name,last_name,patronymic,gender,sDate);
        touristService.save(tourist);
        return "redirect:/admin";
    }

    @GetMapping("/deleteT/{id}")
    public String delete(@PathVariable Long id) {
        touristService.deleteById(id);
        return "redirect:/tourist";
    }

}
