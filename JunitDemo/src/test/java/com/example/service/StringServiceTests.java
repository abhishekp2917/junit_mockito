package com.example.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class StringServiceTests {

    private final StringService stringService;

    public StringServiceTests() {
        this.stringService = new StringService();
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
    private static void beforeAllTestMethod() {
        System.out.println("Calling before all the methods...");
    }

    @AfterAll
    private static void afterAllTestMethod() {
        System.out.println("Calling after all the methods...");
    }

    @ParameterizedTest
    @ValueSource(strings = {"Apple", "Banana"})
    @Tags({
            @Tag("strings"),
            @Tag("service")
    })
    @DisplayName("Should return true if string is empty")
    public void testIsEmpty(String str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        boolean actualResult = stringService.isEmpty(str);
        Assertions.assertFalse(actualResult);
    }
}
