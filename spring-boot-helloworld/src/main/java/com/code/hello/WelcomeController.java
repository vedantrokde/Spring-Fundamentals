package com.code.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @RequestMapping("home")
    public ModelAndView home(@RequestParam("name") String n){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", n);
        mv.setViewName("home.jsp");
        return mv;
    }
}