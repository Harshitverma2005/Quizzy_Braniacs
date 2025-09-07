package com.quizgame.view.console;

import com.quizgame.model.Question;
import com.quizgame.model.QuizSession;
import com.quizgame.model.User;
import com.quizgame.service.QuizService;

import java.util.Scanner;

public class ConsoleGameView {
    private final QuizService quizService;
    private final Scanner scanner;

    public ConsoleGameView(QuizService quizService) {
        this.quizService = quizService;
        this.scanner = new Scanner(System.in);
    }


    public void start() {
        System.out.println("=== Welcome to Harshit Verma's Java Quiz Game ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine().trim();
        User user = new User(username, username + "@example.com");

        String difficulty = promptDifficulty();
        if (difficulty == null) return;

        int numQuestions = promptNumberOfQuestions(difficulty);
        if (numQuestions == -1) return;

        QuizSession session = quizService.createSession(user, difficulty, numQuestions);

        System.out.println("\nStarting Quiz...\n");

        while (session.hasMoreQuestions()) {
            Question question = session.getCurrentQuestion();

            System.out.printf("Q%d: %s\n", session.getCurrentQuestionIndex() + 1, question.getQuestionText());

            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.printf("  %c) %s\n", 'a' + i, options[i]);
            }

            Integer answer = askForAnswer();
            if (answer == null) {
                System.out.printf("You quit the game early. Your current score: %d out of %d\n",
                        session.getScore(), session.getCurrentQuestionIndex());
                return;
            }


            session.submitAnswer(answer);
            session.nextQuestion();
        }

        session.complete();

        System.out.printf("\nQuiz completed! Your score: %d out of %d\n", session.getScore(), session.getTotalQuestions());
        System.out.println("Thank you for playing!");
    }

    private Integer askForAnswer() {
        System.out.print("Your answer (a-d) or 'quit' to exit: ");
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return null;
            if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'd') {
                return input.charAt(0) - 'a';
            }
            System.out.print("Invalid input. Please enter a, b, c, d or 'quit': ");
        }
    }

    private String promptDifficulty() {
        while (true) {
            System.out.print("Choose difficulty (easy/hard), or 'quit' to exit: ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return null;
            if (input.equals("easy") || input.equals("hard")) return input;
            System.out.println("Invalid difficulty. Please enter 'easy' or 'hard'.");
        }
    }

    private int promptNumberOfQuestions(String difficulty) {
        int maxQuestions = quizService.getQuestionsByDifficulty(difficulty).size();
        System.out.printf("How many questions? (1-%d), or 'quit' to exit: ", maxQuestions);
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return -1;
            try {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= maxQuestions) return number;
                System.out.printf("Please enter a number between 1 and %d.\n", maxQuestions);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private Integer promptAnswer() {
        System.out.print("Your answer (a/b/c/d) or 'quit' to exit: ");
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("quit")) return null;
            if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'd') {
                return input.charAt(0) - 'a';
            }
            System.out.print("Invalid option. Please enter a, b, c, d or 'quit': ");
        }
    }
}
