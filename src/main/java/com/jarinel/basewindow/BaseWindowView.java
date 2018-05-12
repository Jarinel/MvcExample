package com.jarinel.basewindow;

import javax.swing.*;
import java.awt.event.ActionListener;

public class BaseWindowView extends JPanel implements View {
    private Controller controller;
    private JTextArea textArea;

    public BaseWindowView() {
        init();
    }

    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        textArea = getTextArea();
        this.add(textArea);

        this.add(getButtons());
    }

    private JTextArea getTextArea() {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        return textArea;
    }

    private JComponent getButtons() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getButton("Назад", e -> controller.handlePrevButtonClick(e)));
        buttonPanel.add(getButton("Вперед", e -> controller.handleNextButtonClick(e)));
        buttonPanel.add(getButton("Редактировать", e -> controller.handleEditButtonClick(e)));
        buttonPanel.add(getButton("Добавить", e -> controller.handleAddButtonClick(e)));

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
    public void setTextToDisplay(String text) {
        textArea.setText(text);
    }
}
