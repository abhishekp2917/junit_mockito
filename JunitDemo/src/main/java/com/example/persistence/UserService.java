package com.example.persistence;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService {

    // mimic user table in database
    private Map<String, String> userTable;

    public UserService() {
        userTable = new HashMap<>();
    }

    public String createUser(String user) {
        String userId = UUID.randomUUID().toString();
        // mimic database call
        this.sleep(5000);
        userTable.put(userId, user);
        return userId;
    }

    public List<String> getUsers() {
        List<String> users = null;
        // mimic database call
        this.sleep(5000);
        users = userTable.values().stream().toList();
        return users;
    }

    public String getUserById(String userId) {
        String user;
        // mimic database call
        this.sleep(5000);
        user = userTable.get(userId);
        return user;
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        }
        catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
