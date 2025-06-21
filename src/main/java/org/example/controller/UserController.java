package org.example.controller;

import org.example.models.User;
import org.example.service.UserService;

public class UserController {
    private final UserService userService = new UserService();

    public boolean register(User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println("❌ Username already exists.");
            return false;
        }
        userService.registerUser(user);
        System.out.println("✅ User registered.");
        return true;
    }

    public boolean login(String username, String password) {
        User user = userService.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("✅ Login successful.");
            return true;
        }
        System.out.println("❌ Invalid credentials.");
        return false;
    }
}
