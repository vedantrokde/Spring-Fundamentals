package com.code.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping(value="/login")
    public String login() {
        return "login";
    }
    @GetMapping(value = "/access-denied")
    public String error(Model model) {
        return "error";
    }
}
