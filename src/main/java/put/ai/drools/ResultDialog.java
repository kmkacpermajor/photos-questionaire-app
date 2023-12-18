package put.ai.drools;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultDialog extends JDialog {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResultDialog(JFrame parentFrame, String result) {
        super(parentFrame, "Question Dialog", true);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel("You should be making this type of pictures: "+result);
        panel.add(label);
        
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel.setBorder(padding);

        JButton answerButton = new JButton("Close");
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(answerButton);

        add(panel);

        setLocationRelativeTo(parentFrame);

        pack();
        setVisible(true);
    }
}