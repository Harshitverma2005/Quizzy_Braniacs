package com.quizgame.console;

import com.quizgame.model.Question;
import com.quizgame.model.QuizSession;
import com.quizgame.model.User;
import com.quizgame.service.QuizService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleGameView {
    private final QuizService quizService;
    private final Scanner scanner;

    public ConsoleGameView(QuizService quizService) {
        this.quizService = quizService;
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        System.out.println("=== Welcome to Enterprise Java Quiz Game ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();
        User user = new User(username, username + "@example.com");

        String difficulty = getDifficultyFromUser();
        if (difficulty == null) return;

        int numQuestions = getNumberOfQuestions(difficulty);
        if (numQuestions == -1) return;

        QuizSession session = quizService.createSession(user, difficulty, numQuestions);

        System.out.println("\nStarting Quiz...\n");

        while (session.hasMoreQuestions()) {
            Question q = session.getCurrentQuestion();

            System.out.printf("Q%d: %s\n", session.getCurrentQuestionIndex() + 1, q.getQuestionText());
            List<String> options = Arrays.asList(q.getOptions());

            for (int i = 0; i < options.size(); i++) {
                System.out.printf("  %c) %s\n", 'a' + i, options.get(i));
            }

            Integer answer = askForAnswer();
            if (answer == null) {
                System.out.println("You chose to quit. Goodbye!");
                return;
            }
            session.submitAnswer(answer);
            session.nextQuestion();
        }

        session.complete();

        System.out.printf("\nQuiz completed! Your score: %d out of %d\n",
                session.getScore(), session.getTotalQuestions());

        System.out.println("Thank you for playing!");
    }

    private String getDifficultyFromUser() {
        while (true) {
            System.out.print("Choose difficulty (easy/hard), or 'quit' to exit: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return null;
            if (input.equals("easy") || input.equals("hard")) {
                return input;
            }
            System.out.println("Invalid input.");
        }
    }

    private int getNumberOfQuestions(String difficulty) {
        int max = quizService.getQuestionsByDifficulty(difficulty).size();
        System.out.printf("How many questions? (1-%d), or 'quit' to exit: ", max);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return -1;
            try {
                int val = Integer.parseInt(input);
                if (val >= 1 && val <= max) {
                    return val;
                }
                System.out.println("Enter a valid number.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    private Integer askForAnswer() {
        System.out.print("Your answer (a-d) or 'quit' to exit: ");
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) {
                return null;
            }
            if (input.length() == 1) {
                char c = input.charAt(0);
                if (c >= 'a' && c <= 'd') {
                    return c - 'a';
                }
            }
            System.out.print("Invalid answer. Enter a-d or 'quit': ");
        }
    }
}
