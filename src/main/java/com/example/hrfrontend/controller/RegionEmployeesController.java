package com.example.hrfrontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionEmployeesController {

    @GetMapping("/region-employees")
    public String regionEmployees() {
        return "region-employees";
    }
}
