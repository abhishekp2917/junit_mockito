package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int first, int second) {
        return first+second;
    }

    public int subtract(int first, int second) {
        return first-second;
    }

    public int multiply(int first, int second) {
        return first*second;
    }

    public int divide(int numerator, int denominator) {
        return numerator/denominator;
    }
}
