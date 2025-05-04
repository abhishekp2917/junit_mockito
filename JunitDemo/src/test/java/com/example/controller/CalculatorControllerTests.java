package com.example.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("controller")
public class CalculatorControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    public CalculatorControllerTests() {
        System.out.println("Calling CalculatorControllerTests constructor.");
    }

    @BeforeEach
    private void beforeEachTestMethod() {
        System.out.println("Calling before each method...");
    }

    @AfterEach
    private void afterEachTestMethod() {
        System.out.println("Calling after each method...");
    }

    @BeforeAll
    private void beforeAllTestMethod() {
        System.out.println("Calling before all the methods...");
    }

    @AfterAll
    private void afterAllTestMethod() {
        System.out.println("Calling after all the methods...");
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "29, -19, 10",
            "0, 0, 0"
    })
    @Order(1)
    @DisplayName("Should call the controller to get addition of two numbers")
    public void testAddTwoNumber(int first, int second, int expectedResult) {
        String url = String.format("http://localhost:%d/calc/add?first=%d&second=%d", this.port, first, second);
        int actualResult = restTemplate.getForObject(url, Integer.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "10, 2, 8",
            "20, 19, 1"
    })
    @Order(2)
    @DisplayName("Should call the controller to get subtraction of two numbers")
    public void testSubtractTwoNumber(int first, int second, int expectedResult) {
        String url = String.format("http://localhost:%d/calc/subtract?first=%d&second=%d", this.port, first, second);
        int actualResult = restTemplate.getForObject(url, Integer.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({"10, 2, 20"})
    @Order(3)
    @Timeout(3)
    @DisplayName("Should call the controller to get multiplication of two numbers")
    public void testMultiplyTwoNumber(int first, int second, int expectedResult) {
        String url = String.format("http://localhost:%d/calc/multiply?first=%d&second=%d", this.port, first, second);
        int actualResult = restTemplate.getForObject(url, Integer.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
