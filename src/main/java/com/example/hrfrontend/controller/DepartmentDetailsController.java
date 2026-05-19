package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentDetailsController {

    @GetMapping("/department-details")
    public String departmentDetails(Model model) {
        model.addAttribute("pageTitle", "Department Details");
        return "department-details";
    }
    
    @GetMapping("/department-change-manager")
    public String changeManager(Model model) {
        model.addAttribute("pageTitle", "Change Department Manager");
        return "department-change-manager";
    }
}
