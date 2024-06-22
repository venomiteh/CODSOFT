package Task_4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class QuizApp {
    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private QuizUi ui;

    public QuizApp(ArrayList<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            if (ui != null) {
                ui.dispose();
            }
            ui = new QuizUi(this, currentQuestion);
        } else {
            JOptionPane.showMessageDialog(null, "Quiz over! Your score: " + score);
        }
    }

    public void submitAnswer(String selectedOption) {
        if (selectedOption != null) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            if (currentQuestion.getCorrectAnswer().equals(selectedOption)) {
                score++;
            }
            currentQuestionIndex++;
            showNextQuestion();
        } else {
            JOptionPane.showMessageDialog(null, "Please select an option.");
        }
    }

    public static void main(String[] args) {
        Question question1 = new Question("What is the capital of France?", List.of("Paris", "London", "Berlin", "Madrid"), "Paris");
        Question question2 = new Question("What is the capital of Lebanon?", List.of("London", "Beirut", "Berlin", "Madrid"), "Beirut");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);

        new QuizApp(questions);
    }
}
