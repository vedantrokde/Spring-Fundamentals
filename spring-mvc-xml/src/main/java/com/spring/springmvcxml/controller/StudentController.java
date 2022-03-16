package com.spring.springmvcxml.controller;

import com.spring.springmvcxml.model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/student")
public class StudentController {
    @RequestMapping("/fillForm")
    public String fillForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "newForm.jsp";
    }
    
    @RequestMapping("/processForm4")
    public String processForm4(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "processForm.jsp";
    }
}
