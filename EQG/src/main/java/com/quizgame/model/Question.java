package com.quizgame.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class Question {
    private Long id;
    private String questionText;
    private String[] options;
    private int correctAnswerIndex;
    private String difficulty;
    private String category;
    private int points;
    private LocalDateTime createdAt;
    private String explanation;

    public Question(String questionText, String[] options, int correctAnswerIndex,
                    String difficulty, String category) {
        this.questionText = questionText;
        this.options = Arrays.copyOf(options, options.length);
        this.correctAnswerIndex = correctAnswerIndex;
        this.difficulty = difficulty;
        this.category = category;
        this.points = calculatePoints(difficulty);
        this.createdAt = LocalDateTime.now();
    }

    private int calculatePoints(String difficulty) {
        switch (difficulty.toLowerCase()) {
            case "easy":
                return 10;
            case "medium":
                return 20;
            case "hard":
                return 30;
            default:
                return 10;
        }
    }

    public boolean isCorrectAnswer(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getQuestionText() { return questionText; }
    public String[] getOptions() { return Arrays.copyOf(options, options.length); }
    public int getCorrectAnswerIndex() { return correctAnswerIndex; }
    public String getDifficulty() { return difficulty; }
    public String getCategory() { return category; }
    public int getPoints() { return points; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getExplanation() { return explanation; }
    public void setExplanation(String explanation) { this.explanation = explanation; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
