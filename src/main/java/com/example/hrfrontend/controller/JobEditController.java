package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobEditController {

    @GetMapping("/job-edit")
    public String showJobEditPage(Model model) {
        model.addAttribute("pageTitle", "Edit Job");
        return "job-edit";
    }
}
