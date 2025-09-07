package com.quizgame.model;

import java.time.LocalDateTime;
import java.util.*;

public class QuizSession {
    private String sessionId;
    private User user;
    private List<Question> questions;
    private Map<Integer, Integer> userAnswers;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int currentQuestionIndex;
    private int score;
    private String difficulty;
    private String category;

    public QuizSession(User user, List<Question> questions, String difficulty, String category) {
        this.sessionId = UUID.randomUUID().toString();
        this.user = user;
        this.questions = new ArrayList<>(questions);
        this.userAnswers = new HashMap<>();
        this.difficulty = difficulty;
        this.category = category;
        this.startTime = LocalDateTime.now();
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public void submitAnswer(int answerIndex) {
        userAnswers.put(currentQuestionIndex, answerIndex);
        Question currentQuestion = getCurrentQuestion();
        if (currentQuestion != null && currentQuestion.isCorrectAnswer(answerIndex)) {
            score += currentQuestion.getPoints();
        }
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public boolean hasMoreQuestions() {
        return currentQuestionIndex < questions.size();
    }

    public void complete() {
        this.endTime = LocalDateTime.now();
    }

    public int getScore() { return score; }
    public int getTotalQuestions() { return questions.size(); }
    public int getCurrentQuestionIndex() { return currentQuestionIndex; }
    public User getUser() { return user; }
}
