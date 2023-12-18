package put.ai.drools;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class QuestionDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String selectedAnswer;

    public QuestionDialog(JFrame parentFrame, String question, ArrayList<String> answers) {
        super(parentFrame, "Question Dialog", true);
        selectedAnswer = null;

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(padding);

        JLabel questionLabel = new JLabel(question);
        panel.add(questionLabel);

        ButtonGroup buttonGroup = new ButtonGroup();
        for (String answer : answers) {
            JRadioButton radioButton = new JRadioButton(answer);
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedAnswer = answer;
                }
            });
            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        JButton answerButton = new JButton("Answer");
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Zamknij okno po udzieleniu odpowiedzi
            }
        });

        panel.add(answerButton);

        add(panel);

        setLocationRelativeTo(parentFrame);

        pack();
        setVisible(true);
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }
}