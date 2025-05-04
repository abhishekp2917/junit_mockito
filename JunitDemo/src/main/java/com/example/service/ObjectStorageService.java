package com.example.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ObjectStorageService {

    private final Map<Integer, String> storage = new HashMap<>();

    public boolean uploadObject(Integer key, String content) {
        if (key == null || content == null) return false;
        storage.put(key, content);
        return true;
    }

    public String getObject(Integer key) {
        return storage.get(key);
    }
}
