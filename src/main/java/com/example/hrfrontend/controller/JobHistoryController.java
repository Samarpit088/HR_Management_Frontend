package com.example.hrfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/job-history")
public class JobHistoryController {

    @Autowired
    private WebClient webClient;

    @GetMapping
    public String jobHistory(
            @RequestParam(required = false) Integer employeeId,
            Model model) {
        
        model.addAttribute("pageTitle", "Job History");
        
        if (employeeId != null) {
            model.addAttribute("employeeId", employeeId);
        }
        
        return "job-history";
    }
    
    @GetMapping("/update")
    public String updateJobHistory(Model model) {
        model.addAttribute("pageTitle", "Update Job History");
        return "job-history-update";
    }
}
