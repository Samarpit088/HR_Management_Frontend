package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeDetailsController {

    @GetMapping("/employee-details")
    public String employeeDetails(Model model) {
        model.addAttribute("pageTitle", "Employee Details");
        return "employee-details";
    }
    
    @GetMapping("/employee-edit")
    public String editEmployee(Model model) {
        model.addAttribute("pageTitle", "Edit Employee");
        return "employee-edit";
    }
}
