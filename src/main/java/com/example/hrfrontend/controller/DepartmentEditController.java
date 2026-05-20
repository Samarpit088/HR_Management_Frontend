package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DepartmentEditController {

    @GetMapping("/department-edit")
    public String showDepartmentEditPage(@RequestParam(required = false) Long departmentId, Model model) {
        model.addAttribute("pageTitle", "Edit Department");
        return "department-edit";
    }
}
