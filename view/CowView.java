package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class CowView extends JFrame {
    private JTextField cowIdField = new JTextField(10);
    private JButton submitButton = new JButton("Check Cow");
    private JTextArea resultArea = new JTextArea(5, 20);

    public CowView() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter Cow ID:"));
        panel.add(cowIdField);
        panel.add(submitButton);
        panel.add(new JScrollPane(resultArea));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cow Farm Management");
        this.setSize(400, 200);
        this.add(panel);
    }

    public String getCowId() {
        return cowIdField.getText();
    }

    public void setResultText(String result) {
        resultArea.setText(result);
    }

    public void addSubmitListener(ActionListener listenForSubmitButton) {
        submitButton.addActionListener(listenForSubmitButton);
    }
}

