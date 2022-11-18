package com.example.calculatorspring.controllers;

import com.example.calculatorspring.com.example.handlingformsubmission.Calculator;
import com.example.calculatorspring.com.example.handlingformsubmission.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping("hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("plus")
    public double plus(double a, double b){
        return a + b;
    }

    @GetMapping("minus")
    public double minus(double a, double b){
        return a - b;
    }

    @GetMapping("multiply")
    public double multiply(double a, double b){
        return a * b;
    }

    @GetMapping("divide")
    public double divide(double a, double b){
        return a / b;
    }

    @GetMapping("/calculate")
    public String calculate(Model model){
        model.addAttribute("calculator", new Calculator());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@ModelAttribute Calculator calculator, Model model){
        switch (calculator.getAction()){
            case "+":
                calculator.setAnswer(String.valueOf(calculator.getA() + calculator.getB()));
                break;
            case "-":
                calculator.setAnswer(String.valueOf(calculator.getA() - calculator.getB()));
                break;
            case "*":
                calculator.setAnswer(String.valueOf(calculator.getA() * calculator.getB()));
                break;
            case "/":
                calculator.setAnswer(String.valueOf(calculator.getA() / calculator.getB()));
                break;
        }
        model.addAttribute("calculator", calculator);
        model.addAttribute("answer", calculator.getAnswer());
        return "calculator";
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
