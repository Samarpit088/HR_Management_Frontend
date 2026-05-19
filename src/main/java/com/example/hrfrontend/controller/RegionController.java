package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/regions")
public class RegionController {

    @GetMapping
    public String listRegions(Model model) {
        model.addAttribute("pageTitle", "Regions");
        return "regions";
    }
}
