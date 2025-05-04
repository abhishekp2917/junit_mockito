package com.example.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Tag("service")
public class CalculatorServiceTests {

    private final CalculatorService calculatorService;

    public CalculatorServiceTests(@Autowired CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Tag("numbers")
    @RepeatedTest(3)
    @DisplayName("Should return the addition of two numbers")
    public void testAddTwoNumbers() {
        int first = 10;
        int second = 20;
        int expectedResult = 30;
        int actualResult = calculatorService.add(first, second);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Tag("numbers")
    @RepeatedTest(10)
    @DisplayName("Should return the subtraction of two numbers")
    public void testSubtractTwoNumbers() {
        int first = 10;
        int second = 20;
        int expectedResult = -10;
        int actualResult = calculatorService.subtract(first, second);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Tag("numbers")
    @RepeatedTest(4)
    @Disabled
    @DisplayName("Should return the multiplication of two numbers")
    public void testMultiplyTwoNumbers() {
        int first = 10;
        int second = 20;
        int expectedResult = 200;
        int actualResult = calculatorService.multiply(first, second);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @Tag("numbers")
    @RepeatedTest(4)
    @DisplayName("Should throw Exception on division by zero")
    public void testDivideByZeroThrowsException() {
        int numerator = 10;
        int denominator = 0;
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(numerator, denominator);
        });
    }
}
