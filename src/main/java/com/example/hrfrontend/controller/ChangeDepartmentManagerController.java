package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeDepartmentManagerController {

    @GetMapping("/change-department-manager")
    public String changeDepartmentManager(Model model) {
        model.addAttribute("pageTitle", "Change Department Manager");
        return "change-department-manager";
    }
}
