package com.codegym.controller;


import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping()
    public ModelAndView showEmail() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("email",new Email());
        modelAndView.addObject("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new String[]{"5", "10", "15", "25","50","100"});

        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView creat(@ModelAttribute Email email){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("email",email);
        modelAndView.addObject("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new String[]{"5", "10", "15", "25","50","100"});
        return modelAndView;
    }
    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Email email){
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("email",email);
        modelAndView.addObject("language", new String[]{"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSize", new String[]{"5", "10", "15", "25","50","100"});
        return modelAndView;
    }
}
