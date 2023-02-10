import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ReverseWordsApp extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JTextArea textArea;
    private JButton reverseButton;

    public ReverseWordsApp() {
        super("Reverse Words");
        setLayout(new FlowLayout());

        label = new JLabel("Enter a sentence:");
        add(label);

        textField = new JTextField(20);
        add(textField);

        reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(this);
        add(reverseButton);

        textArea = new JTextArea(5, 20);
        textArea.setEditable(false);
        add(textArea);

        setSize(250, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sentence = textField.getText();
        String reversedSentence = reverseWords(sentence);
        textArea.setText(reversedSentence);
    }

    private String reverseWords(String sentence) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    reversedSentence.append(stack.pop());
                }
                reversedSentence.append(' ');
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
        }
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        new ReverseWordsApp();
    }
}
