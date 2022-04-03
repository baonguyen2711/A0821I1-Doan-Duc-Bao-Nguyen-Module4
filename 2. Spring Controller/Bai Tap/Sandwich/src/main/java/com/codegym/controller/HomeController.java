package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class HomeController {

    @GetMapping
    public String getIndex() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) String[] condiment, RedirectAttributes redirectAttributes) {
        if (condiment != null) {

            redirectAttributes.addFlashAttribute("condiment", Arrays.toString(condiment));
            return "redirect:/";
        }else {
            String message = "Please click";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/";
        }
    }
}
