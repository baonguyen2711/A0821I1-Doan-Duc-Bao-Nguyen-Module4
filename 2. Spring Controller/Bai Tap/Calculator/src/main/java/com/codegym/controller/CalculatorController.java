package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CalculatorController {
    @GetMapping()
    public String getIndex() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(defaultValue = "0") double number1,
                             @RequestParam(defaultValue = "0") double number2,
                             @RequestParam(defaultValue = "") String calculator,
                             RedirectAttributes redirectAttributes) {
        double result = 0;
        switch (calculator) {
            case "Addition(+)":
                result = number1 + number2;
                calculator = "Addition(+)";
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                calculator = "Subtraction(-)";
                break;
            case "Multiplication(X)":
                result = number1 * number2;
                calculator = "Multiplication(X)";
                break;
            case "Division(/)":
                result = number1 / number2;
                calculator = "Division(/)";
                break;
        }
        redirectAttributes.addFlashAttribute("number1", number1);
        redirectAttributes.addFlashAttribute("number2", number2);
        redirectAttributes.addFlashAttribute("result", result);
        redirectAttributes.addFlashAttribute("calculator", calculator);
        return "redirect:/";
    }
}
