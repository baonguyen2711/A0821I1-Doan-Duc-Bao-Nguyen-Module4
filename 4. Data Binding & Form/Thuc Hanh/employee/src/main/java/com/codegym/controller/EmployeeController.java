package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class EmployeeController {
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping(value = "/addEmployee")
    public ModelAndView submit(@ModelAttribute("employee") Employee employee) {
        ModelAndView modelAndView = new ModelAndView("employee/info");
        modelAndView.addObject("name", employee.getName());
        modelAndView.addObject("contactNumber", employee.getContactNumber());
        modelAndView.addObject("id", employee.getId());
        return modelAndView;
    }
//Cách 2
//    public String submit(@ModelAttribute("employee") Employee employee, Model model) {
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("contactNumber", employee.getContactNumber());
//        model.addAttribute("id", employee.getId());
//        return "employee/info";
//    }
}
