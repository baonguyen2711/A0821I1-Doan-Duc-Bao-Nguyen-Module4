package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    @GetMapping("/dictionary")
    public String dictionary(@RequestParam(required = false,defaultValue = "aaaa") String key, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
        if (dictionary.containsKey(key)) {
            model.addAttribute("dictionary", dictionary.get(key));
        } else {
            model.addAttribute("message", "Not found");
        }
        return "dictionary";
    }
}
