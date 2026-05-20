package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobHistoryDetailsController {

    @GetMapping("/job-history-details")
    public String jobHistoryDetails(Model model) {
        model.addAttribute("pageTitle", "Job History Details");
        return "job-history-details";
    }
}
