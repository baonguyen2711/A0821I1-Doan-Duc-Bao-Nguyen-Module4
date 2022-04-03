package com.codegym.controller;


import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public ModelAndView showForm( ){
        return new ModelAndView("index","user",new User());
    }
    @PostMapping("/checkValidation")
    public ModelAndView checkValidation (@ModelAttribute("user")User user, BindingResult bindingResult){
        new User().validate(user, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }
        else {
            return new ModelAndView("result");
        }
    }
}
