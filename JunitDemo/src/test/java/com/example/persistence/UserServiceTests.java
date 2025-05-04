package com.example.persistence;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
@Tags({
        @Tag("service"),
        @Tag("persistence")
})
public class UserServiceTests {

    @Autowired
    private UserService userService;

    @Nested
    @Order(2)
    class ReadUser {

        @Test
        @DisplayName("Should return users")
        public void testGetUsers() {
            List<String> users = userService.getUsers();
            Assertions.assertNotNull(users);
        }

        @ParameterizedTest
        @ValueSource(strings = {
                "1234",
                "9876"
        })
        @Timeout(2)
        @DisplayName("Should return user based on userId within 2 seconds")
        public void testGetUserById(String id) {
            String user = userService.getUserById(id);
            Assertions.assertNull(user);
        }
    }

    @Nested
    @Order(1)
    class CreateUser {

        @ParameterizedTest
        @ValueSource(strings = {
                "Ravi",
                "Saurabh",
                "Tushar"
        })
        @DisplayName("Should create user")
        public void testCreateUser(String user) {
            String userId = userService.createUser(user);
            Assertions.assertNotNull(userId);
        }
    }
}
