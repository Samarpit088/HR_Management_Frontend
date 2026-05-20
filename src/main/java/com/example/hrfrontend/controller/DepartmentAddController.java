package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DepartmentAddController {

    @GetMapping("/department-add")
    public String departmentAdd(Model model) {
        model.addAttribute("pageTitle", "Add Department");
        return "department-add";
    }
}
