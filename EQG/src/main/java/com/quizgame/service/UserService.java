package com.quizgame.service;

import com.quizgame.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple in-memory user service managing registered users.
 */
public class UserService {
    private final Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    /**
     * Registers a new user with username and email.
     * Returns false if username already exists.
     */
    public boolean registerUser(String username, String email) {
        if (users.containsKey(username)) {
            return false;
        }
        User user = new User(username, email);
        users.put(username, user);
        return true;
    }

    /**
     * Finds user by username.
     */
    public User findUser(String username) {
        return users.get(username);
    }

    /**
     * Updates user statistics.
     */
    public void updateUserStats(String username, int score) {
        User user = users.get(username);
        if (user != null) {
            user.updateStats(score);
        }
    }
}
