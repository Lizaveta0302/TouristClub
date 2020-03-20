package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Supervisor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;


@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/redirect:main").setViewName("main");
    }

    @GetMapping("/")
    public String showForm(Supervisor supervisor) {
        return "adminPage";
    }

    @PostMapping("/")
    public String checkFormInfo(@Valid Supervisor supervisor, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "adminPage";
        }

        return "redirect:/main";
    }
}