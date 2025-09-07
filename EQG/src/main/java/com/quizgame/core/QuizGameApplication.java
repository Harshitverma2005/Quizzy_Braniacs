package com.quizgame.core;

import com.quizgame.service.QuizService;
import com.quizgame.view.console.ConsoleGameView;

public class QuizGameApplication {

    public static void main(String[] args) {
        QuizService quizService = new QuizService();

        if (args.length > 0 && args[0].equalsIgnoreCase("console")) {
            ConsoleGameView consoleView = new ConsoleGameView(quizService);
            consoleView.start();
        } else {
            // For now, default to console version.
            ConsoleGameView consoleView = new ConsoleGameView(quizService);
            consoleView.start();
        }
    }
}
