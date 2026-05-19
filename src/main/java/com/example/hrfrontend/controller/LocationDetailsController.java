package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LocationDetailsController {

    @GetMapping("/location-details")
    public String locationDetails(Model model) {
        model.addAttribute("pageTitle", "Location Details");
        return "location-details";
    }
}
