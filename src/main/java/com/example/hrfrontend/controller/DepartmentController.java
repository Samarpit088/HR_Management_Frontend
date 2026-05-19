package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("pageTitle", "Departments");
        return "departments";
    }
}
