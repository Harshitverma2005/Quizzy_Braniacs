package com.quizgame.service;

import com.quizgame.model.Question;
import com.quizgame.model.QuizSession;
import com.quizgame.model.User;
import com.quizgame.factory.QuestionFactory;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuizService {
    private final List<Question> allQuestions;

    public QuizService() {
        this.allQuestions = QuestionFactory.createSampleQuestions();
    }


    public List<Question> getQuestionsByDifficulty(String difficulty) {


        return allQuestions.stream()
                .filter(q -> q.getDifficulty().equalsIgnoreCase(difficulty))
                .collect(Collectors.toList());

    }


    public QuizSession createSession(User user, String difficulty, int numQuestions) {
        List<Question> filtered = getQuestionsByDifficulty(difficulty);
        Collections.shuffle(filtered);
        if (numQuestions > filtered.size()) numQuestions = filtered.size();
        List<Question> selected = filtered.subList(0, numQuestions);
        return new QuizSession(user, selected, difficulty, "General");
    }
}
