package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @GetMapping
    public String listCountries(Model model) {
        model.addAttribute("pageTitle", "Countries");
        return "countries";
    }
}
