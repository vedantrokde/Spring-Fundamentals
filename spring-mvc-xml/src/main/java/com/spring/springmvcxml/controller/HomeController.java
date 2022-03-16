package com.spring.springmvcxml.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
// @RequestMapping("/demo")
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "home.jsp";
    }

    @RequestMapping("/showForm")
    public String showForm(){
        return "showForm.jsp";
    }

    @RequestMapping("/processForm1")
    public String processForm1(){
        return "processForm.jsp";
    }

    @RequestMapping("/processForm2")
    public String processForm2(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String message = "YO! " + name.toUpperCase();
        model.addAttribute("message", message);
        return "processForm.jsp";
    }

    @RequestMapping("/processForm3")
    public String processForm3(@RequestParam("name") String name, Model model){
        String message = "YOv3! " + name.toUpperCase();
        model.addAttribute("message", message);
        return "processForm.jsp";
    }
}
