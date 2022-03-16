package com.code.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String landing() {
        return "landing";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/leaders")
    public String leaders() {
        return "leaders";
    }
    @GetMapping("/systems")
    public String systems() {
        return "systems";
    }
}
