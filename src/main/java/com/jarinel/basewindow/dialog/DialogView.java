package com.jarinel.basewindow.dialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DialogView extends JDialog implements View {
    private Controller controller;
    private JTextArea textArea;
    private JButton confirmButton;

    public DialogView(Frame owner) {
        super(owner);
        init();
    }

    public void init() {
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setSize(600, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(this.getParent());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        textArea = getTextArea();
        panel.add(textArea);
        panel.add(getButtons());

        this.getContentPane().add(panel);
    }

    public JTextArea getTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);

        return textArea;
    }

    private JComponent getButtons() {
        JPanel buttonPanel = new JPanel();
        confirmButton = getButton("", e -> controller.handleConfirmButtonClick(e));
        buttonPanel.add(confirmButton);
        buttonPanel.add(getButton("Отмена", e -> controller.handleCancelButtonClick(e)));

        return buttonPanel;
    }

    private JButton getButton(String text, ActionListener listener) {
        JButton button = new JButton();
        button.setText(text);
        button.addActionListener(listener);
        return button;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void setDialogTitle(String title) {
        this.setTitle(title);
    }

    @Override
    public void setInputText(String text) {
        textArea.setText(text);
    }

    @Override
    public String getInputText() {
        return textArea.getText();
    }

    @Override
    public void setButtonText(String text) {
        confirmButton.setText(text);
    }

    @Override
    public void closeWindow() {
        dispose();
    }
}
