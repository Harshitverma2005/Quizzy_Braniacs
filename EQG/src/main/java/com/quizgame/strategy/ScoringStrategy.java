package com.quizgame.strategy;

import com.quizgame.model.QuizSession;


public interface ScoringStrategy {

    int calculateScore(QuizSession session);
}
