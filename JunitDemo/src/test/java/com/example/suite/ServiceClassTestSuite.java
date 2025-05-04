package com.example.suite;

import com.example.service.CalculatorServiceTests;
import com.example.service.ObjectStorageServiceTests;
import com.example.service.StringServiceTests;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorServiceTests.class,
        ObjectStorageServiceTests.class,
        StringServiceTests.class
})
public class ServiceClassTestSuite {

}
