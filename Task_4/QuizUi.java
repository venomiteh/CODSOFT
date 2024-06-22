package Task_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class QuizUi extends JFrame {
    JLabel label1;
    private JRadioButton[] optionButtons;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private QuizApp quizApp;

    public QuizUi(QuizApp quizApp, Question question) {
        this.quizApp = quizApp;

        this.setTitle("QUIZ APPLICATION");
        this.setSize(450, 450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        label1 = new JLabel(question.getQuestion());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label1);
        this.add(panel);

        List<String> options = question.getOptions();
        optionButtons = new JRadioButton[options.size()];
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < options.size(); i++) {
            optionButtons[i] = new JRadioButton(options.get(i));
            optionsGroup.add(optionButtons[i]);
            panel.add(optionButtons[i]);
        }
        submitButton = new JButton("Submit");
        panel.add(submitButton);

        // Add action listener to submit button
        submitButton.addActionListener(e -> quizApp.submitAnswer(getSelectedOption()));

        add(panel);
        setVisible(true);
    }

    public String getSelectedOption() {
        for (JRadioButton button : optionButtons) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
