package com.example.model;

import java.util.Map;

public class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public Map<String, String> toMap() {
        return Map.of("name", name);
    }

    public String toString() {
        return "User{" +
              "name='" + name + '\'' +
              '}';
    }
}
