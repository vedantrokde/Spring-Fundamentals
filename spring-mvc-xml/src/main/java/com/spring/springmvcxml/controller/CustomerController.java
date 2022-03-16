package com.spring.springmvcxml.controller;

import javax.validation.Valid;

import com.spring.springmvcxml.model.Customer;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

    // initbinder used everytime preprocessing the request
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        // to trim whitespaces in data
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/custForm")
    public String custForm(Model model) {
        model.addAttribute("customer",  new Customer());
        return "custForm.jsp";
    }

    @RequestMapping("/processForm5")
    public String processForm5( @Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "custForm.jsp";
        } else {
            return "processForm.jsp";
        }
    }
}
