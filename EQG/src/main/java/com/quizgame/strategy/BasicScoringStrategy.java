package com.quizgame.strategy;

import com.quizgame.model.QuizSession;

public class BasicScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(QuizSession session) {
        return session.getScore();
    }
}
