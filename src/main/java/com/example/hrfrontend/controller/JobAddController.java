package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobAddController {

    @GetMapping("/job-add")
    public String showJobAddPage(Model model) {
        model.addAttribute("pageTitle", "Add Job");
        return "job-add";
    }
}
