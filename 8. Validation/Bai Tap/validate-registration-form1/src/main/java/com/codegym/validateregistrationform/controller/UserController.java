package com.codegym.validateregistrationform.controller;

import com.codegym.validateregistrationform.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user", new User());
        return "/index";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phoneNumber")User phoneNumber, BindingResult bindingResult, Model model){
        new User().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "/index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber);
            return "/result";
        }
    }
}
