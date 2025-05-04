package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public int addTwoNumber(@RequestParam int first,@RequestParam int second) {
        int result = calculatorService.add(first, second);
        return result;
    }

    @GetMapping("/subtract")
    public int subtractTwoNumber(@RequestParam int first,@RequestParam int second) {
        int result = calculatorService.subtract(first, second);
        return result;
    }

    @GetMapping("multiply")
    public int multiplyTwoNumber(@RequestParam int first,@RequestParam int second) {
        int result = calculatorService.multiply(first, second);
        return result;
    }

    @GetMapping("divide")
    public int divideTwoNumber(@RequestParam int first,@RequestParam int second) {
        int result = calculatorService.divide(first, second);
        return result;
    }
}
