package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class StringService {

    public boolean isEmpty(String input) {
        return input.length()==0;
    }

    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    public String toLowerCase(String input) {
        return input.toLowerCase();
    }

    public int length(String input) {
        return input.length();
    }

    public String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
