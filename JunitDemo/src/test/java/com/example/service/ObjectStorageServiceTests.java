package com.example.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.function.Executable;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootTest
@Tag("service")
public class ObjectStorageServiceTests {

    @Autowired
    private ObjectStorageService objectStorageService;

    @TestFactory
    public Stream<DynamicTest> testUploadObject() {
        // mimicing fetching of test data from DB, API etc.
        Map<Integer, String> testCases = Map.of(
                1, "Hello World!",
                2, "Hey there!"
        );
        Stream<DynamicTest> dynamicTests = testCases.entrySet().stream().map(entry -> {
            Integer key = entry.getKey();
            String value = entry.getValue();
            String testDisplayName = String.format("Should upload the object with key:%d and return true", key);
            Executable executable = () -> {
                boolean actualResult = objectStorageService.uploadObject(key, value);
                Assertions.assertTrue(actualResult);
            };
            DynamicTest dynamicTest = DynamicTest.dynamicTest(testDisplayName, executable);
            return dynamicTest;
        });
        return dynamicTests;
    }
}
