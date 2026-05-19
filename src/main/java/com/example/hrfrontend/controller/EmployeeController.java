package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("pageTitle", "Employees");
        return "employees";
    }
}
