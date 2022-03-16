package com.code.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("user")
    public ModelAndView user(User user){
        ModelAndView mv = new ModelAndView();
        mv.addObject("user", user);
        mv.setViewName("user.jsp");
        return mv;
    }
}
