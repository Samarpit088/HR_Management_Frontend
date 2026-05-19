package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangeDepartmentManagerController {

    @GetMapping("/change-department-manager")
    public String changeDepartmentManager() {
        return "change-department-manager";
    }
}
