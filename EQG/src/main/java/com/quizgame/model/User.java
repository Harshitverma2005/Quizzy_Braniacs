package com.quizgame.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime createdAt;
    private LocalDateTime lastLoginAt;
    private int totalGamesPlayed;
    private int totalScore;
    private boolean isActive;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.createdAt = LocalDateTime.now();
        this.isActive = true;
        this.totalGamesPlayed = 0;
        this.totalScore = 0;
    }

    public void updateStats(int gameScore) {
        this.totalGamesPlayed++;
        this.totalScore += gameScore;
        this.lastLoginAt = LocalDateTime.now();
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public int getTotalGamesPlayed() { return totalGamesPlayed; }
    public int getTotalScore() { return totalScore; }
    public boolean isActive() { return isActive; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) || Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
