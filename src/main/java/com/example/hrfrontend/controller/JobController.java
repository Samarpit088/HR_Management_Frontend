package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @GetMapping
    public String listJobs(Model model) {
        model.addAttribute("pageTitle", "Jobs");
        return "jobs";
    }
}
