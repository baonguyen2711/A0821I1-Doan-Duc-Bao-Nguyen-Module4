package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

@Controller
public class ConvertController {

    @GetMapping("/convert")
    public String index() {
        return "convert";
    }

    @GetMapping("/usd")
    public String submit(@RequestParam String usd,String rate,String vnd, Model model) {
        float result = Float.parseFloat(usd)*Float.parseFloat(rate);
        float result2 = Float.parseFloat(vnd)/Float.parseFloat(rate);
//        if(){
//            result = Float.parseFloat(usd)*Float.parseFloat(rate);
//        }else {
//            result2 = Float.parseFloat(vnd)/Float.parseFloat(rate);
//        }
        model.addAttribute("result1", result);
        model.addAttribute("result2", result2);
        return "convert";
    }
}
