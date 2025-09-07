package com.quizgame.view.gui;

import com.quizgame.model.Question;
import com.quizgame.model.QuizSession;
import com.quizgame.model.User;
import com.quizgame.service.QuizService;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GuiQuizView extends JFrame {

    private QuizService quizService;
    private QuizSession session;

    private JLabel questionLabel;
    private JButton[] optionButtons;
    private JLabel scoreLabel;
    private JComboBox<String> difficultySelector;
    private JSpinner questionCountSelector;
    private JButton startButton;

    private int currentQuestionIndex = 0;
    private int score = 0;

    public GuiQuizView(QuizService quizService) {
        this.quizService = quizService;
        setTitle("Java Quiz Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        layoutComponents();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        questionLabel = new JLabel("Select difficulty and questions, then click Start.", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        optionButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            int idx = i;
            optionButtons[i] = new JButton();
            optionButtons[i].setVisible(false);
            optionButtons[i].addActionListener(e -> checkAnswer(idx));
        }
        scoreLabel = new JLabel("Score: 0");
        difficultySelector = new JComboBox<>(new String[]{"easy", "hard"});
        questionCountSelector = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        startButton = new JButton("Start Quiz");
        startButton.addActionListener(e -> startQuiz());
    }

    private void layoutComponents() {
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Difficulty:"));
        topPanel.add(difficultySelector);
        topPanel.add(new JLabel("Number of Questions:"));
        topPanel.add(questionCountSelector);
        topPanel.add(startButton);

        JPanel optionsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        for (JButton btn : optionButtons) {
            optionsPanel.add(btn);
        }

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(scoreLabel);

        setLayout(new BorderLayout(10, 10));
        add(topPanel, BorderLayout.NORTH);
        add(questionLabel, BorderLayout.CENTER);
        add(optionsPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    private void startQuiz() {
        String difficulty = (String) difficultySelector.getSelectedItem();
        int numQuestions = (Integer) questionCountSelector.getValue();

        User user = new User("Player", "player@example.com");
        session = quizService.createSession(user, difficulty, numQuestions);
        currentQuestionIndex = 0;
        score = 0;
        scoreLabel.setText("Score: 0");

        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestionIndex >= session.getTotalQuestions()) {
            JOptionPane.showMessageDialog(this,
                    "Quiz Finished! Your score: " + score + " out of " + session.getTotalQuestions());
            resetQuiz();
            return;
        }

        Question question = session.getCurrentQuestion();
        questionLabel.setText("<html>" + question.getQuestionText() + "</html>");
        List<String> opts = Arrays.asList(question.getOptions());
        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText((char) ('a' + i) + ") " + opts.get(i));
            optionButtons[i].setVisible(true);
            optionButtons[i].setEnabled(true);
        }
    }

    private void checkAnswer(int chosenIndex) {
        Question question = session.getCurrentQuestion();
        boolean correct = question.isCorrectAnswer(chosenIndex);

        if (correct) {
            score++;
            JOptionPane.showMessageDialog(this, "Correct!");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Incorrect! Correct answer was: " + (char) ('a' + question.getCorrectAnswerIndex()));
        }

        scoreLabel.setText("Score: " + score);
        session.submitAnswer(chosenIndex);
        session.nextQuestion();
        loadQuestion();
    }

    private void resetQuiz() {
        questionLabel.setText("Select difficulty and questions, then click Start.");
        for (JButton btn : optionButtons) {
            btn.setVisible(false);
        }
        scoreLabel.setText("Score: 0");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GuiQuizView gui = new GuiQuizView(new QuizService());
            gui.setVisible(true);
        });
    }
}
